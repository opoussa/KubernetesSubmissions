package dev.opoussa.todo_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.opoussa.todo_app.client.ITodoClient;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class TodoService {
    
    private final ITodoClient todoClient;

    public TodoService(ITodoClient todoClient) {
        this.todoClient = todoClient;
    }

    public List<String> getTodos() {
        var todos = todoClient.getTodos();
        return todos;
    }

    public void submitTodo(String todo) {
        log.info("Submitting todo: {}", todo);
        todoClient.addTodo(todo);
    }
}
