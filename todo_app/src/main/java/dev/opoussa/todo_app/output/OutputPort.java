package dev.opoussa.todo_app.output;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OutputPort {
    
    @Value("${server.port}")
    private int port;

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        System.out.println("Server started in port " + port);
    }
}
