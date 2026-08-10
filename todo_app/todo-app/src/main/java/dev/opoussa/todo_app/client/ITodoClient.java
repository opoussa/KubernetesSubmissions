package dev.opoussa.todo_app.client;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;


@HttpExchange
public interface ITodoClient {
    @GetExchange
    public List<String> getTodos();

    @PostExchange
    public void addTodo(@RequestBody String todo);
}