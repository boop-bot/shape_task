package edu.epam.task.specification.impl;

import edu.epam.task.entity.Point;
import edu.epam.task.entity.Triangle;
import edu.epam.task.specification.Specification;

import java.util.Arrays;
import java.util.List;

public class PointsIntervalSpecification implements Specification<Triangle> {
    private double pointFrom;
    private double pointTo;

    public PointsIntervalSpecification(double pointFrom, double pointTo) {
        this.pointFrom = pointFrom;
        this.pointTo = pointTo;
    }

    @Override
    public boolean specify(Triangle triangle) {
        List<Point> points = Arrays.asList(triangle.getA(), triangle.getB(), triangle.getC());
        boolean result = points.stream().allMatch(point -> (point.getX() >= pointFrom && point.getX() <= pointTo)
                && (point.getY() >= pointFrom && point.getX() <= pointTo));
        return result;
    }
}
