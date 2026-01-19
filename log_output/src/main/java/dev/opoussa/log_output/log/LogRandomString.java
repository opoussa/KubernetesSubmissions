package dev.opoussa.log_output.log;

import java.time.Instant;
import java.util.UUID;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LogRandomString {
    String random = UUID.randomUUID().toString();

    @Scheduled(fixedRate = 5000)
    void logRandomStringWithTimestamp() {
        System.out.println(Instant.now() + ": " + random);
    }
}