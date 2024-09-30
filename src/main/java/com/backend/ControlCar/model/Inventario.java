package com.backend.ControlCar.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Entity
@Data
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int kmActual;

    private LocalDateTime fecha;

    private String comentario;

    @ManyToOne()
    @JoinColumn(name = "idVehiculo")
    private Vehiculo vehiculo;

    @ManyToOne()
    @JoinColumn(name = "idEstado")
    private Estado estado;

    @ManyToOne()
    @JoinColumn(name = "id_pico_placa")
    private PicoPlaca picoPlaca;

    public interface InventarioRepository extends JpaRepository<Inventario, Integer> {

    }

}