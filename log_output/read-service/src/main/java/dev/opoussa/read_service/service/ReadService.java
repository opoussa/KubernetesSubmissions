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
    private String SHARED_PATH;

    private final String CONFIG_PATH = "/config";

    private final String MESSAGE_ENV_VAR = "MESSAGE";
    
    @Autowired
    private IPingClient pingClient;

    public String readCurrentHash() throws IOException {
        String path = SHARED_PATH + "logs.txt";
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

    public String readFromInformationTxt() throws IOException {
        String path = CONFIG_PATH + "/information.txt";
        System.out.println("Reading information from: " + path);

        Path file = Path.of(path);

        if(!Files.exists(file)) {
            return "File doesn't exist at " + path;
        }
        
        List<String> lines = Files.readAllLines(file);
        int lineAmount = lines.size();

        if ( lineAmount > 0 ) {
           return lines.get(lineAmount - 1);
        
        } else {
            return "No log entries yet.";
        
        }
    }

    public String readFromEnv() {
        String env = System.getenv(MESSAGE_ENV_VAR);
        if (env == null) {
            return "Environment variable '"+MESSAGE_ENV_VAR+"' is not set.";
        }
        return env;
    }

    public String readPings() throws IOException {
        System.out.println("Calling ping service...");
        return pingClient.getPingPongAmount();
    }
}
