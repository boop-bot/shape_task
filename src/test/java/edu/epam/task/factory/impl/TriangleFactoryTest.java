package edu.epam.task.factory.impl;

import edu.epam.task.entity.Point;
import edu.epam.task.entity.Triangle;
import edu.epam.task.exception.FactoryException;
import edu.epam.task.factory.ShapeFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class TriangleFactoryTest {
    private TriangleFactory triangleFactory;

    @BeforeClass
    public void setUp() {
        triangleFactory = TriangleFactory.getInstance();
    }

    @Test
    public void testFactoryCreate() throws FactoryException {
        List<Point> points = Arrays.asList(new Point(1,3), new Point(2,-5), new Point(-8,4));
        Triangle actual = triangleFactory.create(points);
        Triangle expected = new Triangle(points.get(0), points.get(1), points.get(2));
        assertEquals(actual, expected);
    }

    @AfterClass
    public void tearDown() {
        triangleFactory = null;
    }
}