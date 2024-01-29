package br.com.gerenciamento.infra.exceptionCustom;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException() {
        super("Impossível completar a criação de controle. Verifique se há um veículo ou um estabelecimento salvo com essas informações.");
    }
}
