package edu.epam.task.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TriangleDataValidator {
    private static final Logger logger = LogManager.getLogger(TriangleDataValidator.class);
    private static final String POINT_REGEXP = "([-+]?(\\d*)(\\.?\\d*))";
    private static final String DELIMITER = " ";
    private static final int COORDINATES_NUMBER = 6;

    public boolean isValidCoordinate(String pointData) {
        return Pattern.matches(POINT_REGEXP, pointData);
    }

    public boolean isValidTriangle(String triangleData) {
        String[] pointsData = triangleData.split(DELIMITER);
        boolean arePointsValid = Arrays.stream(pointsData).allMatch(this::isValidCoordinate);
        boolean isValid = arePointsValid && (pointsData.length == COORDINATES_NUMBER);
        logger.info("String " + triangleData + " is valid: " + isValid);
        return isValid;
    }

    public List<String> validate(List<String> dataStrings) {
        List<String> validatedStrings = dataStrings.stream().filter(this::isValidTriangle).collect(Collectors.toList());
        logger.info("Strings " + dataStrings + " have valid strings: " + validatedStrings);
        return validatedStrings;
    }

}
