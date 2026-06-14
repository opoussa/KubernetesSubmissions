package dev.opoussa.todo_app.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleRuntimeException(RuntimeException ex) {
        log.error("An unexpected error occurred: {}", ex.getMessage(), ex);
        return "An unexpected error occurred. Please try again later. \n" + ex.getMessage();
    }
}
