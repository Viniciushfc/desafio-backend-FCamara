package br.com.gerenciamento.infra;

import br.com.gerenciamento.dtos.ExceptionDTO;
import br.com.gerenciamento.infra.exceptionCustom.NoDataFoundException;
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

    @ExceptionHandler(Exception.class)
    public ResponseEntity threatGeneralException(DataIntegrityViolationException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");

        return  ResponseEntity.internalServerError().body(exceptionDTO);
    }
}
