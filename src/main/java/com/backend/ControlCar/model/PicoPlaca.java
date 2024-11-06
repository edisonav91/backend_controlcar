package com.backend.ControlCar.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.ToString;
import lombok.Data;


@Entity
@Data
@Table(name = "pico_placas")
public class PicoPlaca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPicoPlaca;

    @OneToMany(mappedBy = "picoPlaca", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Inventario> inventarios;

    private String dia;

    private int numero;

    private boolean vigente;
}