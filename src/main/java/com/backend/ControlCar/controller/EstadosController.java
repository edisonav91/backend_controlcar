package com.backend.ControlCar.controller;

import com.backend.ControlCar.model.Estado;
import com.backend.ControlCar.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}