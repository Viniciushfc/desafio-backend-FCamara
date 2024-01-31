package br.com.gerenciamento.dtos;

import br.com.gerenciamento.entities.vehicle.TypeVehicle;

public record VehicleDTO(String brand, String model, String color, String plate, TypeVehicle typeVehicle) {
}
