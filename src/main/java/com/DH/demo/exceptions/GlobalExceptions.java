package com.DH.demo.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptions {


    @ExceptionHandler({InvalidIDException.class})
    public ResponseEntity<ErrorMessage> processErrorBadRequest (InvalidIDException exception){
        ErrorMessage message = new ErrorMessage();
        message.setMessage ("Ups ocurrió un error");
        message.setDescription(exception.getMessage());
        message.setStatusCode (1001);

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
}
