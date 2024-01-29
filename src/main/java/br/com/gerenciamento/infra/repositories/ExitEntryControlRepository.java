package br.com.gerenciamento.infra.repositories;

import br.com.gerenciamento.domain.establishment.Establishment;
import br.com.gerenciamento.domain.exitEntryControl.ExitEntryControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ExitEntryControlRepository extends JpaRepository<ExitEntryControl, Long> {

    Optional<ExitEntryControl> findExitEntryControlById(Long id);

    Optional<ExitEntryControl> findExitEntryControByEntry(LocalDateTime entry);

}
