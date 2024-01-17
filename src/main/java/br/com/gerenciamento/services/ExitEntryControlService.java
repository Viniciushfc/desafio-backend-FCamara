package br.com.gerenciamento.services;

import br.com.gerenciamento.domain.exitEntryControl.ExitEntryControl;
import br.com.gerenciamento.dtos.ExitEntryControlDTO;
import br.com.gerenciamento.repositories.ExitEntryControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExitEntryControlService {

    @Autowired
    private ExitEntryControlRepository repository;

    public void saveExitEntryControl(ExitEntryControl exitEntryControl) {
        try {
            this.repository.save(exitEntryControl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ExitEntryControl createExitEntryControl(ExitEntryControlDTO dto) {
        try {
            ExitEntryControl exitEntryControl = new ExitEntryControl(dto);
            this.saveExitEntryControl(exitEntryControl);
            return exitEntryControl;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
