package br.com.gerenciamento.core.repositories;

import br.com.gerenciamento.core.domain.employee.Employee;
import br.com.gerenciamento.core.domain.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Employee> findVehicleById(Long id);

    Optional<Employee> findVehicleByBrand(String brand);
}
