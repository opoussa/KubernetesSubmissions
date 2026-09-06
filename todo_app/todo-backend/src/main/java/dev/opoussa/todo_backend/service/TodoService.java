package dev.opoussa.todo_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.opoussa.todo_backend.entity.Todo;
import dev.opoussa.todo_backend.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class TodoService {
    private TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<String> getTodos() {
        log.info("Fetching all todos");
        return repository.findAll().stream()
            .map(Todo::getText)
            .toList();
    }

    public void addTodo(String text) {
        log.info("Adding new todo with text {}", text);
        repository.save(new Todo(text));
    }
    
}
