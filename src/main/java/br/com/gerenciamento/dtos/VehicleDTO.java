package br.com.gerenciamento.dtos;

import br.com.gerenciamento.entities.vehicle.TypeVehicle;

//Uma classe java record utilizada para ser um DATA TRANSFER OBJECT
public record VehicleDTO(String brand, String model, String color, String plate, TypeVehicle typeVehicle) {
}
