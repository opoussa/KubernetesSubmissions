package dev.opoussa.log_output.log;

import java.time.Instant;
import java.util.UUID;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LogRandomString {
    private static String random = UUID.randomUUID().toString();
    private static String current = "";

    @Scheduled(fixedRate = 5000)
    private void logRandomStringWithTimestamp() {
        current = Instant.now() + ": " + random;
        System.out.println(current);
    }

    public static String getCurrent() {
        return current;
    }
}