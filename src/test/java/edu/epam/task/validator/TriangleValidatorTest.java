package edu.epam.task.validator;

import edu.epam.task.entity.Point;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class TriangleValidatorTest {
    private TriangleValidator triangleValidator;

    @BeforeClass
    public void setUp() {
        triangleValidator = new TriangleValidator();
    }

    @Test
    public void testOnePointTriangle() {
        Point a = new Point(1, 1);
        Point b = new Point(1, 1);
        Point c = new Point(1, 1);
        boolean condition = triangleValidator.isTriangle(a,b,c);
        assertFalse(condition);
    }

    @Test
    public void teslLineTriangle() {
        Point a = new Point(1, 1);
        Point b = new Point(2, 2);
        Point c = new Point(3, 3);
        boolean condition = triangleValidator.isTriangle(a,b,c);
        assertFalse(condition);
    }

    @Test
    public void testNormalTriangle() {
        Point a = new Point(0, 0);
        Point b = new Point(5, 0);
        Point c = new Point(-6, -6);
        boolean condition = triangleValidator.isTriangle(a,b,c);
        assertTrue(condition);
    }

    @AfterClass
    public void tearDown() {
        triangleValidator = null;
    }
}