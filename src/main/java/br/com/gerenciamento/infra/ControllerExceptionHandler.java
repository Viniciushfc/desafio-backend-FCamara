package br.com.gerenciamento.infra;

import br.com.gerenciamento.dtos.ExceptionDTO;
import br.com.gerenciamento.infra.util.exceptionCustom.NoDataFoundException;
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

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity handleUnexpectedTypeException(UnexpectedTypeException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Erro inesperado ao validar os dados. Por favor, verifique se os dados fornecidos são do tipo esperado e tente novamente.", "400");

        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity threatGeneralException(DataIntegrityViolationException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");

        return  ResponseEntity.internalServerError().body(exceptionDTO);
    }
}
