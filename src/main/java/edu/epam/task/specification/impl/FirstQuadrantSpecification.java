package edu.epam.task.specification.impl;

import edu.epam.task.entity.Point;
import edu.epam.task.entity.Triangle;
import edu.epam.task.specification.Specification;

public class FirstQuadrantSpecification implements Specification<Triangle> {
    @Override
    public boolean specify(Triangle triangle) {
        Point a = triangle.getA();
        Point b = triangle.getB();
        Point c = triangle.getC();
        boolean result  = (a.getX() >= 0 && a.getY() >= 0)
                && (b.getX() >= 0 && b.getY() >= 0)
                && (c.getX() >= 0 && c.getY() >= 0);
        return result;
    }
}
