package com.backend.ControlCar.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Entity
@Data
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idVehiculo;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Documento> documentos;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inventario> inventarios;

    private String numero_chasis;

    private int modelo;

    private int color;

    private String placa;

    private String vin;

    private boolean transmision4x4;

    private boolean cajaMecanica;

    private int cantidadPasajeros;

    private boolean eliminado;

    @ManyToOne()
    @JoinColumn(name = "idReferencia")
    private Referencia referencia;

}
