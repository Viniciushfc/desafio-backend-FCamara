package br.com.gerenciamento.services;

import br.com.gerenciamento.domain.establishment.Establishment;
import br.com.gerenciamento.domain.exitEntryControl.ExitEntryControl;
import br.com.gerenciamento.domain.vehicle.Vehicle;
import br.com.gerenciamento.dtos.ExitEntryControlDTO;
import br.com.gerenciamento.infra.exception.MissingInformationException;
import br.com.gerenciamento.infra.exception.NoDataFoundException;
import br.com.gerenciamento.infra.repositories.EstablishmentRepository;
import br.com.gerenciamento.infra.repositories.ExitEntryControlRepository;
import br.com.gerenciamento.infra.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static br.com.gerenciamento.infra.util.PriceExitControl.priceExitControl;
import static br.com.gerenciamento.infra.util.VerificationVacancies.verificaVagas;

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
        this.exitEntryControlRepository.save(exitEntryControl);
    }

    //Criar um Controle de entrada/saída.
    public ExitEntryControl createExitEntryControl(ExitEntryControlDTO dto) {
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
        } else {
            throw new NoDataFoundException("Impossível completar a criação de controle. Verifique se há um veículo ou um estabelecimento salvo com essas informações.");
        }
    }

    //Listar todos os cadastros de entrada/saída.
    public List<ExitEntryControl> getAllExitEntryControl() {
        return this.exitEntryControlRepository.findAll();
    }

    //Listar Controles de entrada/saída por I1.
    public ExitEntryControl getExitEntryControlById(Long id) throws Exception {
        return this.exitEntryControlRepository.findExitEntryControlById(id).orElseThrow(() -> new NoDataFoundException("Usuario não encontrado!"));
    }

    //Atualizar cadastros de entrada/saída
    public ExitEntryControl updateExitEntryControl(Long id, ExitEntryControlDTO dto) {
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
        if (!exitEntryControlOptional.isPresent()) {
            throw new NoDataFoundException("Controle de saída/entrada não encontrado para o ID fornecido.");
        }

        throw new MissingInformationException("Impossível completar a operação devido à falta de informações necessárias. Por favor, verifique se todos os campos obrigatórios estão preenchidos corretamente.");
    }


    //Atualizar o controle de saída/entrada e realizar os cálculos dos valores a serem cobrados.
    public ExitEntryControl updateExitControl(Long id) {
        Optional<ExitEntryControl> exitEntryControlOptional = exitEntryControlRepository.findExitEntryControlById(id);

        if (exitEntryControlOptional.isPresent()) {

            ExitEntryControl exitEntryControl = exitEntryControlOptional.get();

            exitEntryControl.setExit(LocalDateTime.now());
            exitEntryControl.setPrice(priceExitControl(exitEntryControl));

            saveExitEntryControl(exitEntryControl);

            return exitEntryControl;
        }
        return null;
    }

    //Deletar um controle de entrada/saída por Id.
    public ExitEntryControl deleteExitEntryControlById(Long id) {
        if (exitEntryControlRepository.existsById(id)) {
            this.exitEntryControlRepository.deleteById(id);
        }
        return null;
    }

    //Deletar um controle de entrada/saída por Horario de entrada. (não implementado)
    public ExitEntryControl deleteExitEntryControlByEntry(LocalDateTime entry) {
        Optional<ExitEntryControl> exitEntryControlOptional = exitEntryControlRepository.findExitEntryControByEntry(entry);

        exitEntryControlOptional.ifPresent(exitEntryControl -> this.exitEntryControlRepository.delete(exitEntryControl));
        return null;
    }

}
