package br.com.gerenciamento.infra.exception;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException(String msg) {
        super(msg);
    }
}
