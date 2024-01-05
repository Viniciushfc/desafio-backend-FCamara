package br.com.gerenciamento.repositories;


import br.com.gerenciamento.core.domain.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findVehicleById(Long id);

    Optional<Vehicle> findVehicleByBrand(String brand);
}
