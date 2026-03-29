package dev.opoussa.read_service.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.opoussa.read_service.service.ReadService;

@Controller
public class ReadController {
    
    @Autowired
    ReadService readService;

    @GetMapping
    public String getCurrentLog(Model model) throws IOException {
        var hash = readService.readCurrentHash();
        var pingPongs = readService.readPings();
        model.addAttribute("hash", hash);
        model.addAttribute("pongCount", pingPongs);
        return "index";
    }
}