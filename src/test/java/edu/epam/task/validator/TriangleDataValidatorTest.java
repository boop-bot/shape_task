package edu.epam.task.validator;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TriangleDataValidatorTest {
    private TriangleDataValidator triangleDataValidator;
    private List<String> triangleData;

    @BeforeClass
    public void setUp() {
        triangleDataValidator = new TriangleDataValidator();
        triangleData = new ArrayList<>();
        triangleData.add("0.0 0. 2.3 0.1 6.6 0.5");
        triangleData.add("");
        triangleData.add("1 1 2 2 -1 3");
        triangleData.add("4 4 10 4 10 10");
        triangleData.add("4.q1 0.1 a.3 4 0 1");
        triangleData.add("1 1 2 2 3 3");
        triangleData.add("1 12 00.1 2 3 ");
        triangleData.add("-1.0 -2. +3 +3 7 11");
    }

    @Test
    public void testValidCoordinate1() {
        String coordinate = "+1.1";
        boolean condition = triangleDataValidator.isValidCoordinate(coordinate);
        assertTrue(condition);
    }

    @Test
    public void testValidCoordinate2() {
        String coordinate = "0.";
        boolean condition = triangleDataValidator.isValidCoordinate(coordinate);
        assertTrue(condition);
    }

    @Test
    public void testValidCoordinate3() {
        String coordinate = "-111";
        boolean condition = triangleDataValidator.isValidCoordinate(coordinate);
        assertTrue(condition);
    }

    @Test
    public void testValidCoordinate4() {
        String coordinate = ".99";
        boolean condition = triangleDataValidator.isValidCoordinate(coordinate);
        assertTrue(condition);
    }

    @Test
    public void testValidCoordinate5() {
        String coordinate = "+00109.99";
        boolean condition = triangleDataValidator.isValidCoordinate(coordinate);
        assertTrue(condition);
    }

    @Test
    public void testInvalidCoordinate1() {
        String coordinate = "1a1";
        boolean condition = triangleDataValidator.isValidCoordinate(coordinate);
        assertFalse(condition);
    }

    @Test
    public void testInvalidCoordinate2() {
        String coordinate = "+-1.0";
        boolean condition = triangleDataValidator.isValidCoordinate(coordinate);
        assertFalse(condition);
    }

    @Test
    public void testValidTriangle() {
        String dataTriangle = "-1.1 +12 010.1 2. 3 4.0";
        boolean condition = triangleDataValidator.isValidTriangle(dataTriangle);
        assertTrue(condition);
    }

    @Test
    public void testNotEnoughDataTriangle() {
        String dataTriangle = "1 12 00.1 2 3 ";
        boolean condition = triangleDataValidator.isValidTriangle(dataTriangle);
        assertFalse(condition);
    }

    @Test
    public void testInvalidDataTriangle() {
        String dataTriangle = "1a1 12 1 a2 3 4";
        boolean condition = triangleDataValidator.isValidTriangle(dataTriangle);
        assertFalse(condition);
    }

    @Test
    public void testValidateStrings() {
        List<String> expected = new ArrayList<>();
        expected.add("0.0 0. 2.3 0.1 6.6 0.5");
        expected.add("1 1 2 2 -1 3");
        expected.add("4 4 10 4 10 10");
        expected.add("1 1 2 2 3 3");
        expected.add("-1.0 -2. +3 +3 7 11");
        List<String> actual = triangleDataValidator.validate(triangleData);
        assertEquals(actual, expected);
    }

    @AfterClass
    public void tearDown() {
        triangleDataValidator = null;
        triangleData = null;
    }
}