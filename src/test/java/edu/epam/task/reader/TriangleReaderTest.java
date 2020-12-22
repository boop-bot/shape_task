package edu.epam.task.reader;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TriangleReaderTest {
    private List<String> expected;
    private TriangleReader triangleReader;

    @BeforeMethod
    public void setUp() {
        triangleReader = new TriangleReader();
        expected = new ArrayList<>();
        expected.add("0.0 0. 2.3 0.1 6.6 0.5");
        expected.add("");
        expected.add("1 1 2 2 -1 3");
        expected.add("4 4 10 4 10 10");
        expected.add("4.q1 0.1 a.3 4 0 1");
        expected.add("1 1 2 2 3 3");
        expected.add("1 12 00.1 2 3");
        expected.add("-1.0 -2. +3 +3 7 11");
    }

    @Test
    public void testReadFile() throws IOException {
        List<String> actual = triangleReader.readFile("data/data.txt");
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        triangleReader = null;
        expected = null;
    }
}