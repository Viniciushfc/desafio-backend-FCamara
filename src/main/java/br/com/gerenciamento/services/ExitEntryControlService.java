package br.com.gerenciamento.services;

import br.com.gerenciamento.domain.establishment.Establishment;
import br.com.gerenciamento.domain.exitEntryControl.ExitEntryControl;
import br.com.gerenciamento.domain.vehicle.TypeVehicle;
import br.com.gerenciamento.domain.vehicle.Vehicle;
import br.com.gerenciamento.dtos.ExitEntryControlDTO;
import br.com.gerenciamento.repositories.EstablishmentRepository;
import br.com.gerenciamento.repositories.ExitEntryControlRepository;

import br.com.gerenciamento.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static br.com.gerenciamento.util.PriceExitControl.priceExitControl;
import static br.com.gerenciamento.util.VerificationVacancies.verificaVagas;

@Service
public class ExitEntryControlService {

    @Autowired
    private EstablishmentRepository establishmentRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ExitEntryControlRepository exitEntryControlRepository;

    //Salvar no banco de dados.
    public void saveExitEntryControl(ExitEntryControl exitEntryControl) {
        try {
            this.exitEntryControlRepository.save(exitEntryControl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Criar um Controle de entrada/saída.
    public ExitEntryControl createExitEntryControl(ExitEntryControlDTO dto) {
        try {
             Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByPlate(dto.plate());
             Optional<Establishment> establishmentOptional = establishmentRepository.findEstablishmentByDocument(dto.document());

            if (vehicleOptional.isPresent() && establishmentOptional.isPresent()) {
                ExitEntryControl exitEntryControl = new ExitEntryControl();

                exitEntryControl.setEntry(LocalDateTime.now());
                exitEntryControl.setVehicle(vehicleOptional.get());
                exitEntryControl.setEstablishment(establishmentOptional.get());

                verificaVagas(exitEntryControl);

                this.saveExitEntryControl(exitEntryControl);

                return exitEntryControl;
            }
        } catch (
                Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    //Listar todos os cadastros de entrada/saída.
    public List<ExitEntryControl> getAllExitEntryControl() {
        try {
            return this.exitEntryControlRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Listar Controles de entrada/saída por I1.
    public ExitEntryControl getExitEntryControlById(Long id) {
        try {
            Optional<ExitEntryControl> exitEntryControlOptional = exitEntryControlRepository.findExitEntryControlById(id);

            if (exitEntryControlOptional.isPresent()) {
                ExitEntryControl exitEntryControl = exitEntryControlOptional.get();

                return exitEntryControl;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Atualizar cadastros de entrada/saída
    public ExitEntryControl updateExitEntryControl(Long id, ExitEntryControlDTO dto) {
        try {
            Optional<ExitEntryControl> exitEntryControlOptional = exitEntryControlRepository.findExitEntryControlById(id);
            Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByPlate(dto.plate());
            Optional<Establishment> establishmentOptional = establishmentRepository.findEstablishmentByDocument(dto.document());

            if (vehicleOptional.isPresent() && establishmentOptional.isPresent() && exitEntryControlOptional.isPresent()) {

                ExitEntryControl exitEntryControl = exitEntryControlOptional.get();

                exitEntryControl.setVehicle(vehicleOptional.get());
                exitEntryControl.setEstablishment(establishmentOptional.get());

                verificaVagas(exitEntryControl);

                saveExitEntryControl(exitEntryControl);

                return exitEntryControl;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Atualizar o controle de saída/entrada e realizar os cálculos dos valores a serem cobrados.
    public ExitEntryControl updateExitControl(Long id) {
        try {
            Optional<ExitEntryControl> exitEntryControlOptional = exitEntryControlRepository.findExitEntryControlById(id);

            if (exitEntryControlOptional.isPresent()) {

                ExitEntryControl exitEntryControl = exitEntryControlOptional.get();

                exitEntryControl.setExit(LocalDateTime.now());
                exitEntryControl.setPrice(priceExitControl(exitEntryControl));

                saveExitEntryControl(exitEntryControl);

                return exitEntryControl;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Deletar um controle de entrada/saída por Id.
    public ExitEntryControl deleteExitEntryControlById(Long id) {
        try {
            if (exitEntryControlRepository.existsById(id)) {
                this.exitEntryControlRepository.deleteById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Deletar um controle de entrada/saída por Horario de entrada. (não implementado)
    public ExitEntryControl deleteExitEntryControlByEntry(LocalDateTime entry) {
        try {
            Optional<ExitEntryControl> exitEntryControlOptional = exitEntryControlRepository.findExitEntryControByEntry(entry);

            exitEntryControlOptional.ifPresent(exitEntryControl -> this.exitEntryControlRepository.delete(exitEntryControl));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
