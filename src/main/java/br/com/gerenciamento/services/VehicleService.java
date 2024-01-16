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
        try {
            this.repository.save(vehicle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Criar um Vehicle e Salvar
    public Vehicle createVehicle(VehicleDTO dto) {
        try {
            Vehicle vehicleNew = new Vehicle(dto);
            this.saveVehicle(vehicleNew);
            return vehicleNew;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Listar todos os Veículos
    public List<Vehicle> getAllVehicle() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Procurar Veículos por ID.
    public Vehicle findVehicleById(Long id) {
        try {
            Optional<Vehicle> optionalVehicle = repository.findVehicleById(id);

            if(optionalVehicle.isPresent()){
                Vehicle vehicle = optionalVehicle.get();

                return vehicle;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Procurar Veículos por Placa.
    public Vehicle findVehicleByPlate(String plate) {
        try {
            Optional<Vehicle> optionalVehicle = repository.findVehicleByPlate(plate);

            if (optionalVehicle.isPresent()) {
                    Vehicle vehicle = optionalVehicle.get();

                return vehicle;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    //Atualizar um Veículos.
    public Vehicle updateVehicle(VehicleDTO dto) {
        try {
            Optional<Vehicle> optionalVehicle = repository.findVehicleByPlate(dto.plate());

            if (optionalVehicle.isPresent()) {
                Vehicle vehicle = optionalVehicle.get();

                vehicle.setBrand(dto.brand());
                vehicle.setModel(dto.model());
                vehicle.setColor(dto.color());
                vehicle.setPlate(dto.plate());
                vehicle.setTypeVehicle(dto.typeVehicle());

                return repository.save(vehicle);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    //Deletar um Veículos por ID.
    public Vehicle deleteVehicleById(Long id) {
        try {
            if (repository.existsById(id)) {
                this.repository.deleteById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Deletar um Veículos por Brand.
    public Vehicle deleteVehicleByPlate(String plate) {
        try {
            Optional<Vehicle> optionalVehicle = repository.findVehicleByPlate(plate);

            if (optionalVehicle.isPresent()) {

                Vehicle vehicle = optionalVehicle.get();

                repository.delete(vehicle);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
