package com.backend.ControlCar.controller;

import com.backend.ControlCar.model.Referencia;
import com.backend.ControlCar.model.Vehiculo;
import com.backend.ControlCar.repository.ReferenciaRepository;
import com.backend.ControlCar.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/vehiculos")
public class VehiculosController {

    @Autowired
    public VehiculoRepository vehiculoRepository;
    @Autowired
    private ReferenciaRepository referenciaRepository;

    @GetMapping("/")
    public String lista(Model model) {
        // Obtengo los datos vehiculo de la BD
        ArrayList<Vehiculo> vehiculos = (ArrayList<Vehiculo>) vehiculoRepository.findAll();

        // Mando la lista de estados a la vista
        model.addAttribute("vehiculos", vehiculos);

        return "vehiculos/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        // Verificar si la marca existe
        if (vehiculoRepository.existsById(id)) {
            vehiculoRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensaje", "Vehiculo eliminado con éxito.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Vehiculo no encontrado.");
        }
        return "redirect:/vehiculos/";
    }

    @PostMapping("/guardar")
    public String guardarVehiculo(@ModelAttribute Vehiculo vehiculo, RedirectAttributes redirectAttributes) {
        try {
            vehiculoRepository.save(vehiculo);
            redirectAttributes.addFlashAttribute("mensaje", "Vehículo agregado con éxito.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Hubo un problema al guardar el Vehículo.");
        }
        return "redirect:/vehiculos/";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());
        model.addAttribute("referencias", referenciaRepository.findAll());
        return "vehiculos/crear";
    }
}
