package dev.opoussa.todo_app.controller;

import dev.opoussa.todo_app.service.ImageService;
import dev.opoussa.todo_app.service.TodoService;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/todo")
public class IndexController {
    private final ImageService imageService;
    private final TodoService todoService;

    IndexController(ImageService imageService, TodoService todoService) {
        this.imageService = imageService;
        this.todoService = todoService;
    }

    @GetMapping
    public String getIndex(Model model) throws IOException {
        var imageSrc = imageService.getImageUrl();
        var todos = todoService.getTodos();
        model.addAttribute("imageSrc", imageSrc);
        model.addAttribute("todos", todos);
        return "index";
    }

    @PostMapping("/submit")
    public String submit(@RequestParam String todo) {
        todoService.submitTodo(todo);
        return "redirect:/todo";
    }
}
