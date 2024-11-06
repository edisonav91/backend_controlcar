package com.backend.ControlCar.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;


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
    private Vehiculo vehiculo;


}