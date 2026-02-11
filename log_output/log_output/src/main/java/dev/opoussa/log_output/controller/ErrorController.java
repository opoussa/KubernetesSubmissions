package dev.opoussa.log_output.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/error")
public class ErrorController {
    @GetMapping
    public String getError() {
        return "Hashgenerator says: Error occurred";
    }
    
}
