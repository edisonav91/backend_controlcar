package com.backend.ControlCar.controller;

import com.backend.ControlCar.model.Marca;
import com.backend.ControlCar.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/marcas")
public class MarcasController {

    @Autowired
    public MarcaRepository marcaRepository;

    @GetMapping("/")
    public String lista(Model model) {
        // Obtengo las marcas de la BD
        ArrayList<Marca> marcas = (ArrayList<Marca>) marcaRepository.findAll();

        // Mando la lista de marcas a la vista
        model.addAttribute("marcas", marcas);

        return "marcas/lista";
    }
}