package dev.opoussa.todo_app.output;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OutputPort {
    private static final Logger log = LoggerFactory.getLogger(OutputPort.class);

    @Value("${server.port}")
    private int port;

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        log.info("Server started in port " + port);
    }
}
