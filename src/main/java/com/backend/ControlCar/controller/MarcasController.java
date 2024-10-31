package com.backend.ControlCar.controller;

import com.backend.ControlCar.model.Marca;
import com.backend.ControlCar.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/marcas")
public class MarcasController {

    @Autowired
    public MarcaRepository marcaRepository;

    @GetMapping("/")
    public String lista(Model model) {
        // Obtengo las marcas de la BD
        ArrayList<Marca> marcas = (ArrayList<Marca>) marcaRepository.findAll();

        // Mando la lista de marcas a la vista
        model.addAttribute("marcas", marcas);

        return "marcas/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        // Verificar si la marca existe
        if (marcaRepository.existsById(id)) {
            marcaRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensaje", "Marca eliminada con éxito.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Marca no encontrada.");
        }
        return "redirect:/marcas/";
    }

    @PostMapping("/guardar")
    public String guardarMarca(@ModelAttribute Marca marca, RedirectAttributes redirectAttributes) {
        try {
            marcaRepository.save(marca);
            redirectAttributes.addFlashAttribute("mensaje", "Marca agregada con éxito.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Hubo un problema al guardar la marca.");
        }
        return "redirect:/marcas/";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        ArrayList<Marca> marcas = (ArrayList<Marca>) marcaRepository.findAll();
        model.addAttribute("marca", new Marca());
        return "marcas/crear";
    }
}