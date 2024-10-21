package com.backend.ControlCar.controller;

import com.backend.ControlCar.model.Marca;
import com.backend.ControlCar.model.PicoPlaca;
import com.backend.ControlCar.repository.MarcaRepository;
import com.backend.ControlCar.repository.PicoPlacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

        return "picoPlaca/lista";
    }
}