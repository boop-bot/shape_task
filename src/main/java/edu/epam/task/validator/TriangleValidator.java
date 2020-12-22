package edu.epam.task.validator;

import edu.epam.task.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TriangleValidator {
    private static final Logger logger = LogManager.getLogger(TriangleValidator.class);

    public boolean isTriangle(Point p1, Point p2, Point p3){
        boolean isTriangle = true;
        if (((p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) - (p3.getX() - p1.getX()) * (p2.getY() - p1.getY())) == 0) {
            isTriangle = false;
        }
        logger.info(p1 + " " + p2 + " " + p3 + " is triangle: " + isTriangle);
        return isTriangle;
    }

}
