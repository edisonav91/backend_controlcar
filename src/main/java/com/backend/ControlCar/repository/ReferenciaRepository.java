package com.backend.ControlCar.repository;

import com.backend.ControlCar.model.Referencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenciaRepository extends JpaRepository<Referencia, Integer> {
}
