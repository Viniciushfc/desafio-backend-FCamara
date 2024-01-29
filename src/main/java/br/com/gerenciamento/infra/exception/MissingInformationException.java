package br.com.gerenciamento.infra.exception;

public class MissingInformationException extends RuntimeException {
    public MissingInformationException(String msg) {
        super(msg);
    }
}
