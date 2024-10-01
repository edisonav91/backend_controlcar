package com.backend.ControlCar.repository;

import com.backend.ControlCar.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
}

