package com.backend.ControlCar.repository;

import com.backend.ControlCar.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
    List<Inventario> findByVehiculo_IdVehiculoOrderByFechaDesc(Integer idVehiculo);
    List<Inventario> findAllByOrderByFechaDesc();
}

