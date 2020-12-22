package edu.epam.task.specification.impl;

import edu.epam.task.entity.Triangle;
import edu.epam.task.entity.TriangleProperty;
import edu.epam.task.specification.Specification;
import edu.epam.task.warehouse.TriangleWarehouse;

public class PerimeterIntervalSpecification implements Specification<Triangle> {
    private double perimeterFrom;
    private double perimeterTo;

    public PerimeterIntervalSpecification(double perimeterFrom, double perimeterTo) {
        this.perimeterFrom = perimeterFrom;
        this.perimeterTo = perimeterTo;
    }

    @Override
    public boolean specify(Triangle triangle) {
        TriangleWarehouse warehouse = TriangleWarehouse.getInstance();
        long id = triangle.getId();
        TriangleProperty property =  warehouse.get(id);
        double perimeter = property.getPerimeter();
        boolean result = (perimeter >= perimeterFrom && perimeter <= perimeterTo);
        return result;
    }
}
