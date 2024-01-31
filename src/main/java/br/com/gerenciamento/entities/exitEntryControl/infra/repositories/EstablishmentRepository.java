package br.com.gerenciamento.entities.exitEntryControl.infra.repositories;

import br.com.gerenciamento.entities.establishment.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Interface de JPARepository
public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {

    Optional<Establishment> findEstablishmentById(Long id);

    Optional<Establishment> findEstablishmentByDocument(String document);

}
