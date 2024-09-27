package com.backend.ControlCar.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;


@Entity
@Data
@Table(name = "Documentos")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocumento;



    private String nombre;

    private LocalDateTime fechaInicioVigencia;

    private LocalDateTime fechaFinVigencia;

    private boolean activo;

    @ManyToOne()
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;

}