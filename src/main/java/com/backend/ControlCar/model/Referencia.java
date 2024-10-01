package com.backend.ControlCar.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Entity
@Data
@Table(name = "referencias")
public class Referencia {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idReferencia;

    @OneToMany(mappedBy = "referencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehiculo> vehiculos;

    private String nombre;

    @ManyToOne()
    @JoinColumn(name = "id_marca")
    private Marca marca;
}

