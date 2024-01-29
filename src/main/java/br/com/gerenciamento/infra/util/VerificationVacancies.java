package br.com.gerenciamento.infra.util;

import br.com.gerenciamento.domain.exitEntryControl.ExitEntryControl;

public class VerificationVacancies {

    public static void verificaVagas(ExitEntryControl exitEntryControl){

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
}
