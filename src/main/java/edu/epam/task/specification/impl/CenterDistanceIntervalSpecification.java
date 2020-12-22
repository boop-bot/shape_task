package edu.epam.task.specification.impl;

import edu.epam.task.entity.Point;
import edu.epam.task.entity.Triangle;
import edu.epam.task.specification.Specification;

import java.util.Arrays;
import java.util.List;

public class CenterDistanceIntervalSpecification implements Specification<Triangle> {
    private double distanceFrom;
    private double distanceTo;

    public CenterDistanceIntervalSpecification(double distanceFrom, double distanceTo) {
        this.distanceFrom = distanceFrom;
        this.distanceTo = distanceTo;
    }

    @Override
    public boolean specify(Triangle triangle) {
        List<Point> points = Arrays.asList(triangle.getA(), triangle.getB(), triangle.getC());
        boolean result = points.stream().allMatch(point -> (Math.hypot(Math.abs(point.getX()), Math.abs(point.getY())) >= distanceFrom
                && (Math.hypot(Math.abs(point.getX()), Math.abs(point.getY())) <= distanceTo)));
        return result;
    }
}
