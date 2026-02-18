package dev.opoussa.write_service.component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WriteComponent {
    private static String random = UUID.randomUUID().toString();

    @Value("${shared.folder.path}")
    private String sharedPath;

    @Scheduled(fixedRate = 5000)
    private void logRandomStringWithTimestamp() {

        try {
            String line = Instant.now() + ": " + random;
            String lineToWrite = line + System.lineSeparator();

            Path file = Path.of(sharedPath);

            // Ensure parent directory exists
            Files.createDirectories(file.getParent());

            file.resolve("logs.txt");

            // Write to file
            Files.writeString(
                file,
                lineToWrite,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
            );

            System.out.println(line);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
