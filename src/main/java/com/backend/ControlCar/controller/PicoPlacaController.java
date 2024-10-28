package com.backend.ControlCar.controller;

import com.backend.ControlCar.model.Marca;
import com.backend.ControlCar.model.PicoPlaca;
import com.backend.ControlCar.repository.MarcaRepository;
import com.backend.ControlCar.repository.PicoPlacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/picoPlacas")
public class PicoPlacaController {

    @Autowired
    public PicoPlacaRepository PicoPlacaRepository;

    @GetMapping("/")
    public String lista(Model model) {
        // Obtengo el Pico y placa de la BD
        ArrayList<PicoPlaca> picoPlacas = (ArrayList<PicoPlaca>) PicoPlacaRepository.findAll();

        // Mando la lista de vehiculos  la vista pico y placa
        model.addAttribute("picoPlacas", picoPlacas);

        return "picoPlacas/lista";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        // Verificar si la marca existe
        if (PicoPlacaRepository.existsById(id)) {
            PicoPlacaRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensaje", "Pico y placa eliminado con éxito.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Pico y placa no encontrado.");
        }
        return "redirect:/picoPlaca";
    }
}