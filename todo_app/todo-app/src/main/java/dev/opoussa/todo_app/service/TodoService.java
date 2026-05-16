package dev.opoussa.todo_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.opoussa.todo_app.client.ITodoClient;

@Service
public class TodoService {
    
    private final ITodoClient todoClient;

    public TodoService(ITodoClient todoClient) {
        this.todoClient = todoClient;
    }

    public void submitTodo(String todo) {
        System.out.println("Submitting todo: " + todo);
        todoClient.addTodo(todo);
    }

    public List<String> getTodos() {
        var todos = todoClient.getTodos();
        return todos;
    }
}
