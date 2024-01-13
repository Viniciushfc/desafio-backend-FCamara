package br.com.gerenciamento.services;


import br.com.gerenciamento.core.domain.Establishment.Establishment;
import br.com.gerenciamento.core.domain.vehicle.Vehicle;
import br.com.gerenciamento.dtos.VehicleDTO;
import br.com.gerenciamento.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository repository;

    //Salvar no Banco de Dados.
    public void saveEstablishment(Vehicle vehicle) {
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
            this.saveEstablishment(vehicleNew);
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

    //Procurar estabelecimento por ID.
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

}
