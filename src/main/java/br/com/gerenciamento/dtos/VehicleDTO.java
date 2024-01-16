package br.com.gerenciamento.dtos;

import br.com.gerenciamento.domain.vehicle.TypeVehicle;

public record VehicleDTO(String brand, String model, String color, String plate, TypeVehicle typeVehicle) {
}
