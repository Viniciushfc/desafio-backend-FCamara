package br.com.gerenciamento.entities.exitEntryControl.infra.exception;

/**
 * Exceção lançada quando nenhum dado é encontrado.
 */
public class NoDataFoundException extends RuntimeException {

    /**
     * Cria uma nova instância da exceção com a mensagem fornecida.
     *
     * @param msg A mensagem que descreve a ausência de dados.
     */
    public NoDataFoundException(String msg) {
        super(msg);
    }
}
