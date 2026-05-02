package dev.opoussa.todo_app.controller;

import dev.opoussa.todo_app.service.ImageService;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    private final ImageService imageService;

    IndexController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public String getIndex(Model model) throws IOException {
        var imageSrc = imageService.getImageUrl();
        model.addAttribute("imageSrc", imageSrc);
        return "index";
    }
    
}
