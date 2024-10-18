package com.backend.ControlCar.repository;

import com.backend.ControlCar.model.PicoPlaca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PicoPlacaRepository extends JpaRepository<PicoPlaca, Integer> {
}
