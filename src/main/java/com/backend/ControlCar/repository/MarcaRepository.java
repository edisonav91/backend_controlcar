package com.backend.ControlCar.repository;

import com.backend.ControlCar.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MarcaRepository extends JpaRepository<Marca, Integer> {
}
