package com.backend.ControlCar.controller;

import com.backend.ControlCar.model.Referencia;
import com.backend.ControlCar.repository.MarcaRepository;
import com.backend.ControlCar.repository.ReferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/referencias")
public class ReferenciasController {

    @Autowired
    public ReferenciaRepository referenciaRepository;
    @Autowired
    private MarcaRepository marcaRepository;


    @GetMapping("/")
    public String lista(Model model) {
        // Obtengo las referencias de la BD
        ArrayList<Referencia> referencias = (ArrayList<Referencia>) referenciaRepository.findAll();

        // Mando la lista de referencias a la vista
        model.addAttribute("referencias", referencias);

        return "referencias/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        // Verificar si la referencia existe
        if (referenciaRepository.existsById(id)) {
            referenciaRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensaje", "Referencia eliminada con éxito.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Referencia no encontrada.");
        }
        return "redirect:/referencias/";
    }

    @PostMapping("/guardar")
    public String guardarReferencia(@ModelAttribute Referencia referencia, RedirectAttributes redirectAttributes) {
        try {
            referenciaRepository.save(referencia);
            redirectAttributes.addFlashAttribute("mensaje", "Referencia agregado con éxito.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Hubo un problema al guardar la referencia.");
        }
        return "redirect:/referencias/";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("referencia", new Referencia());
        model.addAttribute("marcas", marcaRepository.findAll());
        return "referencias/crear";
    }
}