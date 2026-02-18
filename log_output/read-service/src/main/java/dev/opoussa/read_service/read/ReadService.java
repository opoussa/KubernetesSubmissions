package dev.opoussa.read_service.read;

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

    public String readCurrentString() throws IOException {
        
        Path file = Path.of(sharedPath);

        List<String> lines = Files.readAllLines(file);
        int lineAmount = lines.size();

        if ( lineAmount > 0 ) {
           return lines.get(lineAmount - 1);
        
        } else {
            return "No log entries yet.";
        
        }
    }
}
