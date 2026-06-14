package dev.opoussa.todo_app.service;

import org.springframework.stereotype.Service;

import dev.opoussa.todo_app.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
@Slf4j
@Service
public class ImageService {
    @Value("${image.file.path}")
    String imageFilePath;

    private static final String IMAGE_URL_PREFIX = "https://picsum.photos/id/", IMAGE_URL_SUFFIX = "/200/300";

    public String getImageUrl() throws IOException {
        var fileContent = readImageFile();
        var lastModifiedTime = getImageLastModifiedTime(fileContent);

        var imgUrl = fileContent.split("\\R")[0];
        log.info("Image url: {}", imgUrl);
        var has10minPassed = TimeUtil.minutesHavePassed(lastModifiedTime, 10);
        if (has10minPassed) {
            log.info("More than 10 minutes have passed since the image was last modified. Updating image URL.");
            writeNewImageUrlToFile();
        }
        return imgUrl;
    }

    private void writeNewImageUrlToFile() throws IOException {
        int newPicNumber = (int) (Math.random() * (140)) + 1;
        var url = IMAGE_URL_PREFIX + newPicNumber + IMAGE_URL_SUFFIX;
        log.info("New image url: {}", url);
        
        String newContent = url + System.lineSeparator()
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
        log.debug("Reading lines from: {}", path);

        Path file = Path.of(path);

        if (Files.exists(file)) {
            log.debug("File exists. Reading content..");
            String content = Files.readString(file)
                .trim();
            return content;
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
            log.debug("Last modified time unix: {}", lastModifiedTime);
            return lastModifiedTime;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid last modified time format.");
        }
    }
}
