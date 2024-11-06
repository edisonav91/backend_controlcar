package com.backend.ControlCar.controller;

import com.backend.ControlCar.model.Inventario;
import com.backend.ControlCar.repository.EstadoRepository;
import com.backend.ControlCar.repository.InventarioRepository;
import com.backend.ControlCar.repository.PicoPlacaRepository;
import com.backend.ControlCar.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/inventarios")
public class InventariosController {

    @Autowired
    public InventarioRepository inventarioRepository;
    @Autowired
    private VehiculoRepository vehiculoRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PicoPlacaRepository picoPlacaRepository;

    @GetMapping("/")
    public String lista(Model model) {
        // Obtengo los datos inventario de la BD
        ArrayList<Inventario> inventarios = (ArrayList<Inventario>) inventarioRepository.findAll();

        // Mando la lista de inventario a la vista
        model.addAttribute("inventarios", inventarios);

        return "inventarios/lista";

    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        // Verificar si la inventario existe
        if (inventarioRepository.existsById(id)) {
            inventarioRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensaje", "Inventario eliminado con éxito.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Inventario no encontrada.");
        }
        return "redirect:/inventarios/";
    }

    @PostMapping("/guardar")
    public String guardarInventario(@ModelAttribute Inventario inventario, RedirectAttributes redirectAttributes) {
        try {
            inventarioRepository.save(inventario);
            redirectAttributes.addFlashAttribute("mensaje", "Inventario agregado con éxito.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Hubo un problema al guardar el Inventario.");
        }
        return "redirect:/inventarios/";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("inventario", new Inventario());
        model.addAttribute("vehiculos", vehiculoRepository.findAll());
        model.addAttribute("estados", estadoRepository.findAll());
        model.addAttribute("picoPlacas", picoPlacaRepository.findAll());
        return "inventarios/crear";
    }
}