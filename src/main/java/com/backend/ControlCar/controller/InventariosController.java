package com.backend.ControlCar.controller;

import com.backend.ControlCar.model.Inventario;
import com.backend.ControlCar.model.Vehiculo;
import com.backend.ControlCar.repository.InventarioRepository;
import com.backend.ControlCar.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/inventario")
public class InventariosController {

    @Autowired
    public InventarioRepository inventarioRepository;

    @GetMapping("/")
    public String lista(Model model) {
        // Obtengo los datos vehiculo de la BD
        ArrayList<Inventario> inventarios = (ArrayList<Inventario>) inventarioRepository.findAll();

        // Mando la lista de estados a la vista
        model.addAttribute("inventario", inventarios);

        return "inventarios/lista";
    }
}