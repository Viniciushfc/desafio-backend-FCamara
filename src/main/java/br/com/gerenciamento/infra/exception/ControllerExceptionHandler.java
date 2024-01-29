package br.com.gerenciamento.infra.exception;

import br.com.gerenciamento.dtos.ExceptionDTO;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threatDuplicateEntry(DataIntegrityViolationException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Informações já cadastradas", "400");
        return  ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity handleNoDataException(NoDataFoundException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "400");

        return  ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler({UnexpectedTypeException.class, ConstraintViolationException.class})
    public ResponseEntity handleUnexpectedTypeAndConstraintViolationExceptionException(Exception exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Erro inesperado ao validar os dados. Por favor, verifique se os dados fornecidos são o esperado e tente novamente.", "400");

        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity generalException(DataIntegrityViolationException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");

        return  ResponseEntity.internalServerError().body(exceptionDTO);
    }
}
