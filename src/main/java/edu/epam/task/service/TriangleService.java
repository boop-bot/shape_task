package edu.epam.task.service;

import edu.epam.task.entity.Point;
import edu.epam.task.entity.Triangle;

import java.util.List;

public interface TriangleService {
    double findDistance(Point p1, Point p2);
    List<Double> findSides(Triangle triangle);
    double findArea(Triangle triangle);
    double findPerimeter(Triangle triangle);
    boolean isRightAngled(Triangle triangle);
    boolean isIsosceles(Triangle triangle);
    boolean isEquilateral(Triangle triangle);
    boolean isObtuse(Triangle triangle);
    boolean isAcute(Triangle triangle);
}
