package br.com.gerenciamento.repositories;

import br.com.gerenciamento.core.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeeById(Long id);

    Optional<Employee> findEmployeeByDocument(String document);
}
