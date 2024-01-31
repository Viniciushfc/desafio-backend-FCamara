package br.com.gerenciamento.entities.exitEntryControl.infra.exception;

/**
 * Exceção lançada quando informações obrigatórias estão ausentes.
 */
public class MissingInformationException extends RuntimeException {

    /**
     * Cria uma nova instância da exceção com a mensagem fornecida.
     *
     * @param msg A mensagem que descreve a informação ausente.
     */
    public MissingInformationException(String msg) {
        super(msg);
    }
}