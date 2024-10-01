package com.backend.ControlCar.repository;

import com.backend.ControlCar.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Documento, Integer> {
}
