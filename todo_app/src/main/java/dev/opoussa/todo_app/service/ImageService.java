package dev.opoussa.todo_app.service;

import org.springframework.stereotype.Service;

import dev.opoussa.todo_app.util.TimeUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;

@Service
public class ImageService {
    @Value("${image.file.path}")
    String imageFilePath;

    public String getImageUrl() throws IOException {
        var fileContent = readImageFile();
        var lastModifiedTime = getImageLastModifiedTime(fileContent);

        var imgUrl = fileContent.split("\\R")[0];
        System.out.println("Image url: " + imgUrl);
        if (TimeUtil.minutesHavePassed(lastModifiedTime, 10)) {
            System.out
                    .println("More than 10 minutes have passed since the image was last modified. Updating image URL.");
            writeNewImageUrlToFile();
        }
        return imgUrl;
    }

    private void writeNewImageUrlToFile() throws IOException {
        int newPicNumber = (int) (Math.random() * (2000)) + 1;
        System.out.println("Writing new image URL to file: https://picsum.photos/" + newPicNumber);
        String newContent = "https://picsum.photos/" + newPicNumber + System.lineSeparator()
                + System.currentTimeMillis();

        Path file = Path.of(imageFilePath + "imageSrc.txt");
        if (!Files.exists(file)) {
            Files.createDirectories(file.getParent());
            Files.createFile(file);
        }
        Files.writeString(file, newContent);
    }

    private String readImageFile() throws IOException {
        String path = imageFilePath + "imageSrc.txt";
        System.out.println("Reading lines from: " + path);

        Path file = Path.of(path);

        if (Files.exists(file)) {
            String content = Files.readString(file);
            return content.trim();
        } else {
            writeNewImageUrlToFile();
            return readImageFile();
        }
    }

    private Long getImageLastModifiedTime(String fileContent) {
        String[] lines = fileContent.split("\\R");
        if (lines.length < 2 || lines.length > 2) {
            throw new RuntimeException("Invalid image file format.");
        }
        try {
            Long lastModifiedTime = Long.parseLong(lines[1]);
            System.out.println("Last modified time unix: " + lastModifiedTime);
            return lastModifiedTime;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid last modified time format.");
        }
    }
}
