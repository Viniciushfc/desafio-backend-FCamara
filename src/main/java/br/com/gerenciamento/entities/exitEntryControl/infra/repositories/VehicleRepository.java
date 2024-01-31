package br.com.gerenciamento.entities.exitEntryControl.infra.repositories;


import br.com.gerenciamento.entities.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Interface de JPARepository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findVehicleById(Long id);

    Optional<Vehicle> findVehicleByPlate(String plate);

}
