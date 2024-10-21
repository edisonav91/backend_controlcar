package com.backend.ControlCar.controller;

import com.backend.ControlCar.model.Estado;
import com.backend.ControlCar.model.Referencia;
import com.backend.ControlCar.repository.EstadoRepository;
import com.backend.ControlCar.repository.ReferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/referencias")
public class ReferenciasController {

    @Autowired
    public ReferenciaRepository referenciaRepository;

    @GetMapping("/")
    public String lista(Model model) {
        // Obtengo los estados de la BD
        ArrayList<Referencia> referencias = (ArrayList<Referencia>) referenciaRepository.findAll();

        // Mando la lista de estados a la vista
        model.addAttribute("referencias", referencias);

        return "referencias/lista";
    }
}