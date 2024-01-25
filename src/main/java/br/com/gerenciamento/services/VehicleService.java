package br.com.gerenciamento.services;


import br.com.gerenciamento.domain.vehicle.Vehicle;
import br.com.gerenciamento.dtos.VehicleDTO;
import br.com.gerenciamento.repositories.VehicleRepository;
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
    public Vehicle findVehicleById(Long id) {

        Optional<Vehicle> optionalVehicle = repository.findVehicleById(id);

        if (optionalVehicle.isPresent()) {
            Vehicle vehicle = optionalVehicle.get();

            return vehicle;
        }

        return null;
    }

    //Procurar Veículos por Placa.
    public Vehicle findVehicleByPlate(String plate) {

        Optional<Vehicle> optionalVehicle = repository.findVehicleByPlate(plate);

        if (optionalVehicle.isPresent()) {
            Vehicle vehicle = optionalVehicle.get();

            return vehicle;
        }

        return null;
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
        return null;


    }

    //Deletar um Veículos por ID.
    public Vehicle deleteVehicleById(Long id) {

        if (repository.existsById(id)) {
            this.repository.deleteById(id);
        }

        return null;
    }

    //Deletar um Veículos por Brand.
    public Vehicle deleteVehicleByPlate(String plate) {

        Optional<Vehicle> optionalVehicle = repository.findVehicleByPlate(plate);

        if (optionalVehicle.isPresent()) {

            Vehicle vehicle = optionalVehicle.get();

            repository.delete(vehicle);

        }

        return null;
    }
}
