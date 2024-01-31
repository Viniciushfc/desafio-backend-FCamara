package br.com.gerenciamento.entities.exitEntryControl.infra.util;

import br.com.gerenciamento.entities.exitEntryControl.ExitEntryControl;

//Classe Util responsavel pelas vagas
public class Vacancies {

    // Verifica se o estabelecimento ainda possui vagas disponíveis
    public static void verificationVacancies(ExitEntryControl exitEntryControl) {

        switch (exitEntryControl.getVehicle().getTypeVehicle()) {
            case BIKE:
                if (exitEntryControl.getEstablishment().getAmountVacanciesBike() > 0) {
                    exitEntryControl.getEstablishment().setAmountVacanciesBike(exitEntryControl.getEstablishment().getAmountVacanciesBike() - 1);
                } else {
                    throw new RuntimeException("Não há mais vagas para motos neste estabelecimento.");
                }
                break;
            case CAR:
                if (exitEntryControl.getEstablishment().getAmountVacanciesCar() > 0) {
                    exitEntryControl.getEstablishment().setAmountVacanciesCar(exitEntryControl.getEstablishment().getAmountVacanciesCar() - 1);
                } else {
                    throw new RuntimeException("Não há mais vagas para carros neste estabelecimento.");
                }
                break;
            default:
        }
    }

    // Aqui são atribuídas vagas quando é dada a saída de um veículo
    public static void assignsVacancy(ExitEntryControl exitEntryControl) {
        if (exitEntryControl.getExit() != null) {
            switch (exitEntryControl.getVehicle().getTypeVehicle()) {
                case BIKE:
                    exitEntryControl.getEstablishment().setAmountVacanciesBike(exitEntryControl.getEstablishment().getAmountVacanciesBike() + 1);
                    break;
                case CAR:
                    exitEntryControl.getEstablishment().setAmountVacanciesCar(exitEntryControl.getEstablishment().getAmountVacanciesCar() + 1);
                    break;
                default:
            }
        }
    }
}
