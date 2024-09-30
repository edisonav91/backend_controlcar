package com.backend.ControlCar;

import com.backend.ControlCar.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public class ControlCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlCarApplication.class, args);
	}

	public interface DocumentoRepository extends JpaRepository<Documento, Integer> {
	}

	public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	}

	public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
	}

	public interface MarcaRepository extends JpaRepository<Marca, Integer> {
	}

	public interface PicoPlacaRepository extends JpaRepository<PicoPlaca, Integer> {
	}

	public interface ReferenciaRepository extends JpaRepository<Referencia, Integer> {
	}

	public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
	}
}


