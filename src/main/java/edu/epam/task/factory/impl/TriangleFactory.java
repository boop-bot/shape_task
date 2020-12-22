package edu.epam.task.factory.impl;

import edu.epam.task.entity.Point;
import edu.epam.task.entity.Triangle;
import edu.epam.task.exception.FactoryException;
import edu.epam.task.factory.ShapeFactory;
import edu.epam.task.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TriangleFactory implements ShapeFactory<Triangle> {
    private static final Logger logger = LogManager.getLogger(TriangleFactory.class);
    private static TriangleFactory instance = new TriangleFactory();

    private TriangleFactory() {}

    public static TriangleFactory getInstance() {
        return instance;
    }

    @Override
    public Triangle create(List<Point> points) throws FactoryException {
        TriangleValidator triangleValidator = new TriangleValidator();
        if (!triangleValidator.isTriangle(points.get(0), points.get(1), points.get(2))) {
            throw new FactoryException("Incorrect points provided!");
        }
        Triangle triangle = new Triangle(points.get(0), points.get(1), points.get(2));
        logger.info("Created triangle with points: {} {} {}",points.get(0), points.get(1), points.get(2));
        return triangle;
    }
}
