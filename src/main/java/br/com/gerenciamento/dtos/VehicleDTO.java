package br.com.gerenciamento.dtos;

import br.com.gerenciamento.core.domain.vehicle.TypeVehicle;

public record VehicleDTO(String brand, String model, String color, String plate, TypeVehicle typeVehicle) {
}
