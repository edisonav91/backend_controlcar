package com.backend.ControlCar.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "estados")
public class Estado {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idEstado;

    private String nombre;

}