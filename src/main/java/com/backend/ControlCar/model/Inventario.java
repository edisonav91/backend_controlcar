package com.backend.ControlCar.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idInventario;

    private int kmActual;

    private String fecha;

    private String comentario;

    @ManyToOne()
    @JoinColumn(name = "idVehiculo")
    @ToString.Exclude
    private Vehiculo vehiculo;

    @ManyToOne()
    @JoinColumn(name = "idEstado")
    @ToString.Exclude
    private Estado estado;

    @ManyToOne()
    @JoinColumn(name = "idPicoPlaca")
    @ToString.Exclude
    private PicoPlaca picoPlaca;
}