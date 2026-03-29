package dev.opoussa.read_service.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.opoussa.read_service.service.ReadService;

@RestController("/")
public class ReadController {
    
    @Autowired
    ReadService readService;

    @GetMapping
    public String getCurrentLog() throws IOException {
        return readService.readCurrentHash();
    }
}