package com.backend.ControlCar.controller;

import com.backend.ControlCar.model.Documento;
import com.backend.ControlCar.model.Marca;
import com.backend.ControlCar.repository.DocumentoRepository;
import com.backend.ControlCar.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/documentos")
public class DocumentosController {

    @Autowired
    public DocumentoRepository documentoRepository;

    @GetMapping("/")
    public String lista(Model model) {
        // Obtengo los documentos de la BD
        ArrayList<Documento> documentos = (ArrayList<Documento>) documentoRepository.findAll();

        // Mando la lista de documentos a la vista
        model.addAttribute("documentos", documentos);

        return "documentos/lista";
    }
}