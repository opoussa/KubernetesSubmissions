package dev.opoussa.todo_app.component;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class VersionLogger {

    private final BuildProperties buildProperties;

    public VersionLogger(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void logVersion() {
        log.info("Running version {}", buildProperties.getVersion());
        log.info("Backend URL: {}", System.getenv("BACKEND_URL"));
        log.info("Image API url: {}", System.getenv("IMAGE_API_URL"));
    }
}
