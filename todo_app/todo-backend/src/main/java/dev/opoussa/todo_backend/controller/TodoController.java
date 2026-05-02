package dev.opoussa.todo_backend.controller;

import org.springframework.web.bind.annotation.RestController;

import dev.opoussa.todo_backend.service.TodoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<String> getTodos() {
        return todoService.getTodos();
    }
    
    @PostMapping
    public ResponseEntity<String> addTodo(@RequestBody String todo) {
        todoService.addTodo(todo);
        return ResponseEntity.ok("Todo added succesfully!"); 
    }
}
