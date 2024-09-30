package com.backend.ControlCar.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Entity
@Data
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public int idMarca;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Referencia> referencia;

    public String nombre;


}


