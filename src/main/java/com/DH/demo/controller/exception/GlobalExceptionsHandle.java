package com.DH.demo.controller.exception;

import com.DH.demo.exceptions.EntityNotFoundException;
import com.DH.demo.exceptions.IntegrityDataException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsHandle {

    private final Logger logger = Logger.getLogger ( GlobalExceptionsHandle.class );

    @ExceptionHandler({IntegrityDataException.class})
    public ResponseEntity<java.lang.Error> procesarErrorBadRequest (IntegrityDataException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(handlerException(ex));
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<java.lang.Error> procesarErrorNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                handlerException(ex)
        );
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<java.lang.Error> procesarAnyException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(handlerException(ex));
    }

    private java.lang.Error handlerException(Throwable ex){
        logger.error(ex.getMessage());
        return new java.lang.Error( ex.getClass().getSimpleName());
    }


}
