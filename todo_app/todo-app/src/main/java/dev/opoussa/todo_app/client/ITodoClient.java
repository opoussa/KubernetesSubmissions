package dev.opoussa.todo_app.client;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange(url = "http://todo-backend-svc:2345")
public interface ITodoClient {
    /*
        TODO : I/O error on GET request for "http://todo-backend-svc:2345/": null], 
        template might not exist or might not be accessible by any of the configured Template Resolvers
    */
    @GetExchange
    public List<String> getTodos();

    @PostExchange
    public void addTodo(@RequestBody String todo);
}