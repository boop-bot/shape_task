package edu.epam.task.observer.impl;

import edu.epam.task.entity.Triangle;
import edu.epam.task.entity.TriangleProperty;
import edu.epam.task.observer.Observer;
import edu.epam.task.service.impl.TriangleServiceImpl;
import edu.epam.task.warehouse.TriangleWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleObserver implements Observer<Triangle> {
    private static final Logger logger = LogManager.getLogger(TriangleObserver.class);

    @Override
    public void performedPerimeter(Triangle triangle) {
        Long id = triangle.getId();
        TriangleServiceImpl triangleService = TriangleServiceImpl.getInstance();
        TriangleWarehouse triangleWarehouse = TriangleWarehouse.getInstance();
        double perimeter = triangleService.findPerimeter(triangle);
        TriangleProperty triangleProperty = triangleWarehouse.get(id);
        triangleProperty.setPerimeter(perimeter);
        triangleWarehouse.put(id, triangleProperty);
        logger.info("perimeter updated in {} , new perimeter: {}",triangle,perimeter);
    }

    @Override
    public void performedArea(Triangle triangle) {
        Long id = triangle.getId();
        TriangleServiceImpl triangleService = TriangleServiceImpl.getInstance();
        TriangleWarehouse triangleWarehouse = TriangleWarehouse.getInstance();
        double area = triangleService.findArea(triangle);
        TriangleProperty triangleProperty = triangleWarehouse.get(id);
        triangleProperty.setArea(area);
        triangleWarehouse.put(id, triangleProperty);
        logger.info("area updated in {} , new area: {}",triangle,area);
    }
}
