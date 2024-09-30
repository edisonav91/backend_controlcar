package com.backend.ControlCar.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import lombok.Data;


@Entity
@Data
@Table(name = "pico_placas")
public class PicoPlaca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPicoPlaca;

    @OneToMany(mappedBy = "picoPlaca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inventario> inventarios;

   private LocalDateTime dia;

    private int numero;

    private boolean vigente;

    public interface PicoPlacaRepository extends JpaRepository<PicoPlaca, Integer> {
    }

}