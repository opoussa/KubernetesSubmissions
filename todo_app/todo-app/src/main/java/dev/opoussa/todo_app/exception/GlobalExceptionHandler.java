package dev.opoussa.todo_app.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleRuntimeException(RuntimeException ex) {
        // Log the exception (you can use a logging framework here)
        System.err.println("An error occurred: " + ex.getMessage());
        // Return a generic error message to the user
        return "An unexpected error occurred. Please try again later. \n" + ex.getMessage();
    }
}
