package br.com.gerenciamento.entities.exitEntryControl.infra.exception;

import br.com.gerenciamento.dtos.ExceptionDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Esta classe é responsável por lidar com exceções globais lançadas pelos controladores.
 *
 * Esta classe é um componente Spring que intercepta exceções lançadas pelos controladores
 * e fornece respostas HTTP apropriadas com base no tipo de exceção.
 *
 * Ela inclui métodos para tratar diferentes tipos de exceções, como
 * DataIntegrityViolationException, NoDataFoundException, UnexpectedTypeException e ConstraintViolationException.
 *
 * Para cada tipo de exceção tratada, um ResponseEntity é retornado com um objeto ExceptionDTO contendo detalhes
 * sobre o erro, incluindo a mensagem de erro e o código de status HTTP correspondente.
 *
 * Além disso, este controlador também tem um método genérico para lidar com exceções não previstas, retornando um código de status 500
 * em caso de falha interna do servidor.
 *
 * Esta classe é um controlador de aconselhamento global para toda a aplicação,
 * permitindo que ela intercepte exceções lançadas em qualquer controlador dentro da aplicação.
 *
 * Todos os métodos de tratamento de exceções nesta classe retornam um ResponseEntity contendo um objeto ExceptionDTO
 * para fornecer uma resposta JSON estruturada com informações sobre o erro.
 *
 * @author ViniciusHFC
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

    /**
     * Trata exceções de violação de integridade de dados.
     */
    public ResponseEntity threatDuplicateEntry(DataIntegrityViolationException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Informações já cadastradas", "400");
        return  ResponseEntity.badRequest().body(exceptionDTO);
    }

    /**
     * Trata exceções de ausência de dados.
     */
    public ResponseEntity handleNoDataException(NoDataFoundException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "400");
        return  ResponseEntity.badRequest().body(exceptionDTO);
    }

    /**
     * Trata exceções de tipo inesperado e violação de restrição.
     */
    public ResponseEntity handleUnexpectedTypeAndConstraintViolationExceptionException(Exception exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Erro inesperado ao validar os dados. Por favor, verifique se os dados fornecidos são o esperado e tente novamente.", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    /**
     * Trata exceções gerais.
     */
    public ResponseEntity generalException(DataIntegrityViolationException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");
        return  ResponseEntity.internalServerError().body(exceptionDTO);
    }
}

