package com.backend.ControlCar.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public int idMarca;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Referencia> referencias;

    public String nombre;
}


