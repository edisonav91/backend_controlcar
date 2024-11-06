package com.backend.ControlCar.controller;

import com.backend.ControlCar.model.Documento;
import com.backend.ControlCar.model.Marca;
import com.backend.ControlCar.model.Vehiculo;
import com.backend.ControlCar.repository.DocumentoRepository;
import com.backend.ControlCar.repository.MarcaRepository;
import com.backend.ControlCar.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/documentos")
public class DocumentosController {

    @Autowired
    public DocumentoRepository documentoRepository;
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @GetMapping("/")
    public String lista(Model model) {
        // Obtengo los documentos de la BD
        ArrayList<Documento> documentos = (ArrayList<Documento>) documentoRepository.findAll();

        // Mando la lista de documentos a la vista
        model.addAttribute("documentos", documentos);

        return "documentos/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        // Verificar si la marca existe
        if (documentoRepository.existsById(id)) {
            documentoRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensaje", "Documento eliminado con éxito.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Documento no encontrado.");
        }
        return "redirect:/documentos/";
    }

    @PostMapping("/guardar")
    public String guardarVehiculo(@ModelAttribute Documento documento, RedirectAttributes redirectAttributes) {
        try {
            documentoRepository.save(documento);
            redirectAttributes.addFlashAttribute("mensaje", "Documento agregado con éxito.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Hubo un problema al guardar el Documento.");
        }
        return "redirect:/documentos/";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("documento", new Documento());
        model.addAttribute("vehiculos", vehiculoRepository.findAll());
        return "documentos/crear";
    }
}
