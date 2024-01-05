package br.com.gerenciamento.repositories;

import br.com.gerenciamento.core.domain.Establishment.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {

    Optional<Establishment> findEstablishmentById(Long id);

    Optional<Establishment> findEstablishmentByDocument(String document);
}