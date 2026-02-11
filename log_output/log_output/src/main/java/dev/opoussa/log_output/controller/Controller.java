package dev.opoussa.log_output.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.opoussa.log_output.log.LogRandomString;

@RestController("/")
public class Controller {
    
    @GetMapping
    public String getCurrentLog() {
        return LogRandomString.getCurrent();
    }
}