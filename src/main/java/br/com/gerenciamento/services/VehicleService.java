package br.com.gerenciamento.services;


import br.com.gerenciamento.entities.vehicle.Vehicle;
import br.com.gerenciamento.dtos.VehicleDTO;
import br.com.gerenciamento.entities.exitEntryControl.infra.exception.MissingInformationException;
import br.com.gerenciamento.entities.exitEntryControl.infra.exception.NoDataFoundException;
import br.com.gerenciamento.entities.exitEntryControl.infra.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    //Salvar no Banco de Dados.
    public void saveVehicle(Vehicle vehicle) {
        this.repository.save(vehicle);
    }

    //Criar um Vehicle e Salvar
    public Vehicle createVehicle(VehicleDTO dto) {
        Vehicle vehicleNew = new Vehicle(dto);
        this.saveVehicle(vehicleNew);
        return vehicleNew;
    }

    //Listar todos os Veículos
    public List<Vehicle> getAllVehicle() {
        return repository.findAll();
    }

    //Procurar Veículos por ID.
    public Vehicle findVehicleById(Long id) throws Exception {
        return this.repository.findById(id).orElseThrow(() -> new NoDataFoundException("Usuario não encontrado!"));
    }

    //Procurar Veículos por Placa.
    public Vehicle findVehicleByPlate(String plate) {
        return this.repository.findVehicleByPlate(plate).orElseThrow(() -> new NoDataFoundException("Usuario não encontrado!"));
    }

    //Atualizar um Veículos.
    public Vehicle updateVehicle(VehicleDTO dto) {
        Optional<Vehicle> optionalVehicle = repository.findVehicleByPlate(dto.plate());

        if (optionalVehicle.isPresent()) {
            Vehicle vehicle = optionalVehicle.get();

            vehicle.setBrand(dto.brand());
            vehicle.setModel(dto.model());
            vehicle.setColor(dto.color());
            vehicle.setPlate(dto.plate());
            vehicle.setTypeVehicle(dto.typeVehicle());

            return repository.save(vehicle);
        }
        throw new MissingInformationException("Impossível completar a operação devido à falta de informações necessárias. Por favor, verifique se todos os campos obrigatórios estão preenchidos corretamente.");
    }

    //Deletar um Veículos por ID.
    public Vehicle deleteVehicleById(Long id) {
        if (repository.existsById(id)) {
            this.repository.deleteById(id);
        }
        throw new NoDataFoundException("Usuario não encontrado!");
    }

    //Deletar um Veículos por Brand.
    public Vehicle deleteVehicleByPlate(String plate) {

        Optional<Vehicle> optionalVehicle = repository.findVehicleByPlate(plate);

        if (optionalVehicle.isPresent()) {

            Vehicle vehicle = optionalVehicle.get();

            repository.delete(vehicle);

        }
        throw new NoDataFoundException("Usuario não encontrado!");
    }
}
