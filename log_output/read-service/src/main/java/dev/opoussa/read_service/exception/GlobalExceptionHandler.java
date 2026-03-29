package dev.opoussa.read_service.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handeGeneralException(Exception ex) {
        System.out.println("An error occurred: " + ex.getMessage() + "\n" + ex.getStackTrace());
        String error = "An error occurred: \n" + ex.getMessage() + "\n" + ex.getStackTrace();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    
    }
    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handeIOException(IOException ex) {
        System.out.println("An IO exception occurred: " + ex.getMessage() + "\n" + ex.getStackTrace());
        String error = "An error occurred: \n" + ex.getMessage() + "\n" + ex.getStackTrace();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    
    }
}
