package com.backend.ControlCar.repository;

import com.backend.ControlCar.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface    DocumentoRepository extends JpaRepository<Documento, Integer> {
}
