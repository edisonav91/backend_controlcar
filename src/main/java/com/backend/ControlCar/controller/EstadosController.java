package com.backend.ControlCar.controller;

import com.backend.ControlCar.model.Estado;
import com.backend.ControlCar.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/estados")
public class EstadosController {

    @Autowired
    public EstadoRepository estadoRepository;

    @GetMapping("/")
    public String lista(Model model) {
        // Obtengo los estados de la BD
        ArrayList<Estado> estados = (ArrayList<Estado>) estadoRepository.findAll();

        // Mando la lista de estados a la vista
        model.addAttribute("estados", estados);

        return "estados/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        // Verificar si el estado existe
        if (estadoRepository.existsById(id)) {
            estadoRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensaje", "Estado eliminada con éxito.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Estado no encontrada.");
        }
        return "redirect:/estados/";
    }

    @PostMapping("/guardar")
    public String guardarEstado(@ModelAttribute Estado estado, RedirectAttributes redirectAttributes) {
        try {
            estadoRepository.save(estado);
            redirectAttributes.addFlashAttribute("mensaje", "Estado agregado con éxito.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Hubo un problema al guardar el estado.");
        }
        return "redirect:/estados/";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("estado", new Estado());
        return "estados/crear";
    }
}

