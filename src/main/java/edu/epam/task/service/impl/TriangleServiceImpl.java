package edu.epam.task.service.impl;

import edu.epam.task.entity.Point;
import edu.epam.task.entity.Triangle;
import edu.epam.task.service.TriangleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleServiceImpl implements TriangleService {
    private static final Logger logger = LogManager.getLogger(TriangleServiceImpl.class);
    private static final TriangleServiceImpl instance = new TriangleServiceImpl();

    private TriangleServiceImpl() {}

    public static TriangleServiceImpl getInstance() {
        return instance;
    }

    @Override
    public double findDistance(Point p1, Point p2) {
        double dx = Math.abs(p1.getX() - p2.getX());
        double dy = Math.abs(p1.getY() - p2.getY());
        double distance = Math.sqrt(dx*dx + dy*dy);
        logger.info("Distance between points: " + p1 + " and " + p2 + " = " + distance);
        return distance;
    }

    @Override
    public List<Double> findSides(Triangle triangle) {
        List<Double> lengths = new ArrayList<>();
        lengths.add(findDistance(triangle.getA(),triangle.getB()));
        lengths.add(findDistance(triangle.getB(),triangle.getC()));
        lengths.add(findDistance(triangle.getA(),triangle.getC()));
        logger.info("Found sides length:" + lengths.toString());
        return lengths;
    }

    @Override
    public double findArea(Triangle triangle) {
        Point p1 = triangle.getA();
        Point p2 = triangle.getB();
        Point p3 = triangle.getC();
        double area = Math.abs((p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) - (p3.getX() - p1.getX()) * (p2.getY() - p1.getY())) / 2;
        logger.info("Area of " + triangle + " : " + area);
        return area;
    }

    @Override
    public double findPerimeter(Triangle triangle) {
        List<Double> sides = findSides(triangle);
        double perimeter = sides.get(0) + sides.get(1) + sides.get(2);
        logger.info("Perimeter of " + triangle + " : " + perimeter);
        return perimeter;
    }

    @Override
    public boolean isRightAngled(Triangle triangle) {
        List<Double> sides = findSides(triangle);
        double ab = sides.get(0);
        double bc = sides.get(1);
        double ac = sides.get(2);
        boolean isRectangular = false;
        if ((ab * ab + bc * bc - ac * ac) <= 0x1p-32 || (bc * bc + ac * ac - ab * ab) <= 0x1p-32 || (ac * ac + ab * ab - bc * bc) <= 0x1p-32) {
            isRectangular = true;
        }
        logger.info(triangle + " is right angled: " + isRectangular);
        return isRectangular;
    }

    @Override
    public boolean isIsosceles(Triangle triangle) {
        List<Double> sides = findSides(triangle);
        boolean isIsosceles = (sides.get(0) - sides.get(1) <= 0x1p-32) || (sides.get(1) - sides.get(2) <= 0x1p-32)
                || (sides.get(1) - sides.get(2) <= 0x1p-32);
        logger.info(triangle + " is isosceles: " + isIsosceles);
        return isIsosceles;
    }

    @Override
    public boolean isEquilateral(Triangle triangle) {
        List<Double> sides = findSides(triangle);
        boolean isEquilateral = (sides.get(0) - sides.get(1) <= 0x1p-32) && (sides.get(1) - sides.get(2) <= 0x1p-32);
        logger.info(triangle + " is equilateral: " + isEquilateral);
        return isEquilateral;
    }

    @Override
    public boolean isObtuse(Triangle triangle) {
        List<Double> sides = findSides(triangle);
        double ab = sides.get(0);
        double bc = sides.get(1);
        double ac = sides.get(2);
        boolean isObtuse = false;
        if (ab * ab > bc * bc + ac * ac || bc * bc > ab * ab + ac * ac || ac * ac > bc * bc + ab * ab){
            isObtuse = true;
        }
        logger.info(triangle + " is obtuse: " + isObtuse);
        return isObtuse;
    }

    @Override
    public boolean isAcute(Triangle triangle) {
        List<Double> sides = findSides(triangle);
        double ab = sides.get(0);
        double bc = sides.get(1);
        double ac = sides.get(2);
        boolean isObtuse = false;
        if (ab * ab < bc * bc + ac * ac && bc * bc < ab * ab + ac * ac && ac * ac < bc * bc + ab * ab){
            isObtuse = true;
        }
        logger.info(triangle + " is acute: " + isObtuse);
        return isObtuse;
    }
}
