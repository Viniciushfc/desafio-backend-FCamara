package br.com.gerenciamento.infra.repositories;

import br.com.gerenciamento.entities.establishment.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {

    Optional<Establishment> findEstablishmentById(Long id);

    Optional<Establishment> findEstablishmentByDocument(String document);

}
