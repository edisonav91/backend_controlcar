package com.backend.ControlCar.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


@Entity
@Data
@Table(name = "Documentos")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocumento;

    private String nombre;

    private String fechaInicioVigencia;

    private String fechaFinVigencia;

    private boolean activo;

    @ManyToOne()
    @JoinColumn(name = "idVehiculo")
    @ToString.Exclude
    private Vehiculo vehiculo;
}