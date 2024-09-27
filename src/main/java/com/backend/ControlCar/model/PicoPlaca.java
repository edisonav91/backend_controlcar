package com.backend.ControlCar.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;


@Entity
@Data
@Table(name = "pico_placas")
public class PicoPlaca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPicoPlaca;

    @OneToMany(mappedBy = "picoPlaca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inventario> inventarios;

   private LocalDateTime dia;

    private int numero;

    private boolean vigente;

}