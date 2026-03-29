package dev.opoussa.ping_pong.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class PingService {
    @Value("${shared.folder.path}")
    private String sharedPath;

    private static final String FILE_NAME = "pings.txt";

    public void logPingPongCount() {
        try  {
            Path file = Path.of(sharedPath, FILE_NAME);
            System.out.println("Writing to file: " + file);

            Files.createDirectories(file.getParent());

            int currentCount = 0;
            if (Files.exists(file)) {
                String content = Files.readString(file);
                currentCount = content.isBlank() ? 0 : Integer.parseInt(content.trim());
            }

            currentCount++;
            String line = String.valueOf(currentCount);

            Files.writeString(
                file,
                line,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPingPongCount() throws IOException {
        Path file = Path.of(sharedPath + FILE_NAME);
        if (Files.exists(file)) {
            String content = Files.readString(file);
            return content.trim();
        }
        throw new IOException("File not found: " + sharedPath);
    }
}