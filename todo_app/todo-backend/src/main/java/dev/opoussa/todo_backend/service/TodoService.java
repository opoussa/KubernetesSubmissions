package dev.opoussa.todo_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private static List<String> todos = new ArrayList<>();

    public List<String> getTodos() {
        return todos;
    }

    public void addTodo(String todo) {
        todos.add(todo);
    }
    
}
