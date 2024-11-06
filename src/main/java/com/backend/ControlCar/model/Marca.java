package com.backend.ControlCar.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.util.List;

@Entity
@Data
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public int idMarca;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Referencia> referencia;

    public String nombre;
}


