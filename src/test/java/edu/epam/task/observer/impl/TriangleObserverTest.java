package edu.epam.task.observer.impl;

import edu.epam.task.entity.Point;
import edu.epam.task.entity.Triangle;
import edu.epam.task.entity.TriangleProperty;
import edu.epam.task.exception.RepositoryException;
import edu.epam.task.repository.Repository;
import edu.epam.task.repository.impl.TriangleRepository;
import edu.epam.task.service.TriangleService;
import edu.epam.task.service.impl.TriangleServiceImpl;
import edu.epam.task.warehouse.TriangleWarehouse;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleObserverTest {
    public Repository<Triangle> repository;
    public TriangleWarehouse triangleWarehouse;

    @BeforeClass
    public void setUp() throws RepositoryException {
        repository = TriangleRepository.getInstance();
        triangleWarehouse = TriangleWarehouse.getInstance();

        Triangle triangle = new Triangle(new Point(0,0),new Point(5,0),new Point(0,5));
        TriangleService triangleService = TriangleServiceImpl.getInstance();
        double area = triangleService.findArea(triangle);
        double perimeter = triangleService.findPerimeter(triangle);
        long id = triangle.getId();
        TriangleProperty triangleProperty = new TriangleProperty(area,perimeter);
        repository.add(triangle);
        triangleWarehouse.put(id, triangleProperty);
    }

    @Test
    public void observerTest() throws RepositoryException {
        Triangle triangle = repository.get(0);
        TriangleObserver observer = new TriangleObserver();
        triangle.attach(observer);
        Point point = new Point(1,1);
        triangle.setA(point);
        TriangleService triangleService = TriangleServiceImpl.getInstance();
        double area = triangleService.findArea(triangle);
        double perimeter = triangleService.findPerimeter(triangle);
        long id = triangle.getId();
        TriangleProperty triangleProperty = triangleWarehouse.get(id);
        boolean condition = (area == triangleProperty.getArea()) && (perimeter == triangleProperty.getPerimeter());
        assertTrue(condition);
    }

    @AfterClass
    public void tearDown() {
        repository = null;
        triangleWarehouse = null;
    }
}