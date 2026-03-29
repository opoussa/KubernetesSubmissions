package dev.opoussa.read_service.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReadService {

    @Value("${shared.folder.path}")
    private String sharedPath;
    
    public String readCurrentHash() throws IOException {
        String path = sharedPath + "logs.txt";
        System.out.println("Reading logs from: " + path);

        Path file = Path.of(path);

        if(!Files.exists(file)) {
            return "No log entries yet.";
        }
        
        List<String> lines = Files.readAllLines(file);
        int lineAmount = lines.size();

        if ( lineAmount > 0 ) {
           return lines.get(lineAmount - 1);
        
        } else {
            return "No log entries yet.";
        
        }
    }

    public String readPings() throws IOException {
        String path = sharedPath + "pings.txt";
        System.out.println("Reading lines from: " + path);

        Path file = Path.of(path);

        if (Files.exists(file)) {
            String content = Files.readString(file);
            return content.trim();
        } else {
            return "No ping entries yet.";
        }
    }
}
