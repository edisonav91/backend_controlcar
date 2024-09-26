package com.backend.ControlCar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Marcas")
public class Marca {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public int idReferencia;

    public String marcaNombre;

    public Marca (){

    }

    public Marca (int idReferencia, String marcaNombre) {
        this.idReferencia = idReferencia;
        this.marcaNombre = marcaNombre;
    }
}


