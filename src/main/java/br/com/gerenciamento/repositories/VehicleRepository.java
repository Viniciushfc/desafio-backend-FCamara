package br.com.gerenciamento.repositories;


import br.com.gerenciamento.domain.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findVehicleById(Long id);

    Optional<Vehicle> findVehicleByPlate(String plate);

}
