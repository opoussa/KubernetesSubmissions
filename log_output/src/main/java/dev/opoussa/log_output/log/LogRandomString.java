package dev.opoussa.log_output.log;

import java.time.Instant;
import java.util.UUID;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LogRandomString {

    @Scheduled(fixedRate = 5000)
    void logRandomStringWithTimestamp() {
        String random = UUID.randomUUID().toString();

        System.out.println(random + " " + Instant.now());
    }
}
