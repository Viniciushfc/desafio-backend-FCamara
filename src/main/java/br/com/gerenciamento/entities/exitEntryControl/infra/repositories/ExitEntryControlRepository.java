package br.com.gerenciamento.entities.exitEntryControl.infra.repositories;

import br.com.gerenciamento.entities.exitEntryControl.ExitEntryControl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

//Interface de JPARepository
public interface ExitEntryControlRepository extends JpaRepository<ExitEntryControl, Long> {

    Optional<ExitEntryControl> findExitEntryControlById(Long id);

    Optional<ExitEntryControl> findExitEntryControByEntry(LocalDateTime entry);

}
