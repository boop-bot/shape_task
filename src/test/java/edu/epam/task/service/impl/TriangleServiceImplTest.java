package edu.epam.task.service.impl;

import edu.epam.task.entity.Point;
import edu.epam.task.entity.Triangle;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class TriangleServiceImplTest {
    private TriangleServiceImpl triangleService;

    @BeforeClass
    public void setUp() {
        triangleService = TriangleServiceImpl.getInstance();
    }

    @AfterClass
    public void tearDown() {
        triangleService = null;
    }

    @Test
    public void testFindDistance() {
        double expected = 10;
        double actual = triangleService.findDistance(new Point(0, 0), new Point(0, 10));
        assertEquals(actual, expected);
    }

    @Test
    public void testFindSides() {
        List<Double> expected = Arrays.asList(3., 5., 4.);
        List<Double> actual = triangleService.findSides(new Triangle(new Point(0,0), new Point(3, 0), new Point(0, 4)));
        assertEquals(actual, expected);
    }

    @Test
    public void testFindArea() {
        double expected = 6;
        double actual = triangleService.findArea(new Triangle(new Point(0,0), new Point(3, 0), new Point(0, 4)));
        assertEquals(actual, expected);
    }

    @Test
    public void testFindPerimeter() {
        double expected = 12;
        double actual = triangleService.findPerimeter(new Triangle(new Point(0,0), new Point(3, 0), new Point(0, 4)));
        assertEquals(actual, expected);
    }

    @Test
    public void testIsRightAngled() {
        boolean condition = triangleService.isRightAngled(new Triangle(new Point(0,0), new Point(3, 0), new Point(0, 3)));
        assertTrue(condition);
    }

    @Test
    public void testIsIsosceles() {
        boolean condition = triangleService.isIsosceles(new Triangle(new Point(0,0), new Point(3, 0), new Point(0, 3)));
        assertTrue(condition);
    }

    @Test
    public void testIsEquilateral() {
        boolean condition = triangleService.isEquilateral(new Triangle(new Point(-1.5,0), new Point(1.5,0), new Point(0, 3 * Math.sqrt(3) / 2)));
        assertTrue(condition);
    }

    @Test
    public void testIsObtuse() {
        boolean condition = triangleService.isObtuse(new Triangle(new Point(0,5), new Point(-10, 0), new Point(0, 10)));
        assertTrue(condition);
    }

    @Test
    public void testIsAcute() {
        boolean condition = triangleService.isAcute(new Triangle(new Point(-1.5,0), new Point(1.5,0), new Point(0, 3 * Math.sqrt(3) / 2)));
        assertTrue(condition);
    }
}