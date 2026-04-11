package dev.opoussa.read_service.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import dev.opoussa.read_service.client.IPingClient;

@Service
public class ReadService {

    @Value("${shared.folder.path}")
    private String sharedPath;
    
    @Autowired
    private IPingClient pingClient;

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
        System.out.println("Calling ping service...");
        return pingClient.getPingPongAmount();
    }
}
