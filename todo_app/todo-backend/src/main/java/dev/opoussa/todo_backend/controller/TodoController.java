package dev.opoussa.todo_backend.controller;

import org.springframework.web.bind.annotation.RestController;

import dev.opoussa.todo_backend.service.TodoService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
public class TodoController {

    private final TodoService todoService;

    TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<String> getTodos() {
        log.info("Getting todos...");
        return todoService.getTodos();
    }
    
    @PostMapping
    public ResponseEntity<String> addTodo(@RequestBody String todo) {
        log.info("Adding todo: {}", todo);
        todoService.addTodo(todo);
        return ResponseEntity.ok("Todo added succesfully!"); 
    }
}
