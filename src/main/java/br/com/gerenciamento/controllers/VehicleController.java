package br.com.gerenciamento.controllers;

import br.com.gerenciamento.domain.vehicle.Vehicle;
import br.com.gerenciamento.dtos.VehicleDTO;
import br.com.gerenciamento.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody VehicleDTO dto){
        Vehicle vehicle = vehicleService.createVehicle(dto);
        return new ResponseEntity<>(vehicle, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicle(){
        List<Vehicle> vehicles = this.vehicleService.getAllVehicle();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) throws Exception {
        Vehicle vehicle = this.vehicleService.findVehicleById(id);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @GetMapping("plate/{plate}")
    public ResponseEntity<Vehicle> getVehicleByBrand(@PathVariable String plate){
        Vehicle vehicle = vehicleService.findVehicleByPlate(plate);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody VehicleDTO dto){
        Vehicle vehicle = vehicleService.updateVehicle(dto);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicleById(@PathVariable Long id){
        Vehicle vehicle = vehicleService.deleteVehicleById(id);
    }

    @DeleteMapping("/plate/{plate}")
    public void deleteVehicleByPlate(@PathVariable String plate){
        Vehicle vehicle = vehicleService.deleteVehicleByPlate(plate);
    }
}
