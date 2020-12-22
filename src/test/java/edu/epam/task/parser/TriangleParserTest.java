package edu.epam.task.parser;

import edu.epam.task.entity.Point;
import edu.epam.task.exception.TriangleParserException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class TriangleParserTest {
    private TriangleParser triangleParser;

    @BeforeClass
    public void setUp() {
        triangleParser = new TriangleParser();
    }

    @Test
    public void testParsePoints1() throws TriangleParserException {
        String triangleData = "0 0 1.1 +2.2 010.0 -10.0";
        List<Point> expected = Arrays.asList(new Point(0,0), new Point(1.1, 2.2), new Point(10, -10));
        List<Point> actual = triangleParser.parsePoints(triangleData);
        assertEquals(actual, expected);
    }

    @AfterClass
    public void tearDown() {
        triangleParser = null;
    }
}