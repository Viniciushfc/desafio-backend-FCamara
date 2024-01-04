package br.com.gerenciamento.repositories;

import br.com.gerenciamento.core.entity.employee.Employee;
import br.com.gerenciamento.core.entity.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Employee> findVehicleById(Long id);

    Optional<Employee> findVehicleByBrand(String brand);
}
