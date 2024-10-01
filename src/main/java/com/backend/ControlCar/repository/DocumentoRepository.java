package com.backend.ControlCar.repository;

import com.backend.ControlCar.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Integer> {
}
