package br.com.gerenciamento.dtos;

//Uma classe java record utilizada para ser um DATA TRANSFER OBJECT
public record EstablishmentDTO(String name, String document, String address, String telephone, Integer amountVacanciesBike, Integer amountVacanciesCar) {

}
