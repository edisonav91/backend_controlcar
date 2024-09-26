package com.backend.ControlCar.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "referencias")
public class Referencia {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idReferencia;

    private String nombre;

    @ManyToOne()
    @JoinColumn(name = "id_marca")
    private Marca marca;
}

