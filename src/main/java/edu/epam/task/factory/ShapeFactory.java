package edu.epam.task.factory;

import edu.epam.task.entity.Point;
import edu.epam.task.entity.Shape;
import edu.epam.task.exception.FactoryException;

import java.util.List;

public interface ShapeFactory<T extends Shape> {
    T create(List<Point> points) throws FactoryException;
}
