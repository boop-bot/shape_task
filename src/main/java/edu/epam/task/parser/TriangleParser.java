package edu.epam.task.parser;

import edu.epam.task.entity.Point;
import edu.epam.task.exception.TriangleParserException;
import edu.epam.task.validator.TriangleDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleParser {
    private static final Logger logger = LogManager.getLogger(TriangleParser.class);
    private final String DELIMITER = " ";

    public List<Point> parsePoints(String triangleData) throws TriangleParserException {
        TriangleDataValidator dataValidator = new TriangleDataValidator();
        if (!dataValidator.isValidTriangle(triangleData)) {
            logger.error("Invalid input for parsing");
            throw new TriangleParserException("Invalid input");
        }
        List<Point> points = new ArrayList<>();
        String[] pointsCoordinates = triangleData.split(DELIMITER);
        for (int i = 0; i < pointsCoordinates.length; i += 2) {
            points.add(new Point(Double.parseDouble(pointsCoordinates[i]), Double.parseDouble(pointsCoordinates[i + 1])));
        }
        logger.info("Triangle data parsed to points: " + triangleData);
        return points;
    }
}
