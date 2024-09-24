package com.backend.ControlCar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Estados")
public class Estado {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idEstado;

    private String nombre;
}
