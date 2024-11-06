package com.backend.ControlCar.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.util.List;

@Entity
@Data
@Table(name = "estados")
public class Estado {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idEstado;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Inventario> inventarios;

    private String nombre;
}
