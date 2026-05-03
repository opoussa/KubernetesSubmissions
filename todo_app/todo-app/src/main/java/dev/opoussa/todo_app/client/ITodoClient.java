package dev.opoussa.todo_app.client;

import java.util.List;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange(url = "http://todo-backend-svc:2345")
public interface ITodoClient {

    @GetExchange
    public List<String> getTodos();

    @PostExchange
    public void addTodo(String todo);
}