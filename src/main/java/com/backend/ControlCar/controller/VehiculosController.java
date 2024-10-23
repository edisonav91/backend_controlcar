package com.backend.ControlCar.controller;

import com.backend.ControlCar.model.Referencia;
import com.backend.ControlCar.model.Vehiculo;
import com.backend.ControlCar.repository.ReferenciaRepository;
import com.backend.ControlCar.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/vehiculos")
public class VehiculosController {

    @Autowired
    public VehiculoRepository vehiculoRepository;

    @GetMapping("/")
    public String lista(Model model) {
        // Obtengo los datos vehiculo de la BD
        ArrayList<Vehiculo> vehiculos = (ArrayList<Vehiculo>) vehiculoRepository.findAll();

        // Mando la lista de estados a la vista
        model.addAttribute("vehiculos", vehiculos);

        return "vehiculos/lista";
    }
}