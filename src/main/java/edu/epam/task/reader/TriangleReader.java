package edu.epam.task.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TriangleReader {
    private static final Logger logger = LogManager.getLogger(TriangleReader.class);

    public List<String> readFile(String path) throws IOException {
        logger.info("Reading triangle data from file");
        List<String> text = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(path))){
            text = lines.collect(Collectors.toList());
            logger.info("Data readed from file by path " + path);
        } catch (IOException e) {
            logger.error("error while reading file by path: " + path + ", error: " + e.getMessage());
            throw new IOException();
        }
        logger.info("End of reading data");
        return text;
    }

}
