package com.piggyBank.piggyBank.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class HandleException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CoinValueException.class)
    public final ResponseEntity<String> handleUserNotFoundException(CoinValueException ex, WebRequest request) {
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServicePathException.class)
    public final ResponseEntity<String> handleUserNotFoundException(ServicePathException ex, WebRequest request) {
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<String> handleUserNotFoundException(Exception ex, WebRequest request) {
        return new ResponseEntity<String>("Something went wrong!!",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


