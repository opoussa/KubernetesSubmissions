package dev.opoussa.read_service.read;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class ReadController {
    
    @Autowired
    ReadService readService;

    @GetMapping
    public String getCurrentLog() throws IOException {
        return readService.readCurrentString();
    }
}