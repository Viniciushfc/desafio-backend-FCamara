package br.com.gerenciamento.entities.exitEntryControl.infra.util;

import br.com.gerenciamento.entities.exitEntryControl.ExitEntryControl;

import java.time.Duration;

public class PriceExitControl {
    // Classe responsável por calcular o valor consumido pelo veículo em um estacionamento
    public static Double priceExitControl(ExitEntryControl exitEntryControl){
        long durationInHours = Duration.between(exitEntryControl.getEntry(), exitEntryControl.getExit()).toMinutes();
        double hourlyRate = 0.0;

        switch (exitEntryControl.getVehicle().getTypeVehicle()) {
            case BIKE:
                hourlyRate = 15.0;
                break;
            case CAR:
                hourlyRate = 20.0;
                break;
            default:
        }
        return durationInHours * hourlyRate;
    }
}
