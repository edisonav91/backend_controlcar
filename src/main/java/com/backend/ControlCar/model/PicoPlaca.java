package com.backend.ControlCar.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;


@Entity
@Data
@Table(name = "pico_placas")
public class PicoPlaca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPicoPlaca;
    private LocalDateTime dia;

    private int numero;

    private boolean vigente;

}