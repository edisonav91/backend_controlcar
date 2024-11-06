package com.backend.ControlCar.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "referencias")
public class Referencia {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idReferencia;

    @OneToMany(mappedBy = "referencia", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Vehiculo> vehiculos = new ArrayList<>();;

    private String nombre;

    @ManyToOne()
    @JoinColumn(name = "id_marca")
    @ToString.Exclude
    private Marca marca;
}

