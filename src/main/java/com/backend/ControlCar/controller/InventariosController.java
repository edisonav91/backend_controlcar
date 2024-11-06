package com.backend.ControlCar.controller;

import com.backend.ControlCar.model.Inventario;
import com.backend.ControlCar.model.Vehiculo;
import com.backend.ControlCar.repository.InventarioRepository;
import com.backend.ControlCar.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/inventarios")
public class InventariosController {

    @Autowired
    public InventarioRepository inventarioRepository;

    @GetMapping("/")
    public String lista(Model model) {
        // Obtengo los datos inventario de la BD
        ArrayList<Inventario> inventarios = (ArrayList<Inventario>) inventarioRepository.findAll();

        // Mando la lista de inventario a la vista
        model.addAttribute("inventario", inventarios);

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
}