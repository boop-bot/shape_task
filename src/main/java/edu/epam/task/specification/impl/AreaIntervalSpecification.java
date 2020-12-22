package edu.epam.task.specification.impl;

import edu.epam.task.entity.Triangle;
import edu.epam.task.entity.TriangleProperty;
import edu.epam.task.specification.Specification;
import edu.epam.task.warehouse.TriangleWarehouse;

public class AreaIntervalSpecification implements Specification<Triangle> {
    private double areaFrom;
    private double areaTo;

    public AreaIntervalSpecification(double areaFrom, double areaTo) {
        this.areaFrom = areaFrom;
        this.areaTo = areaTo;
    }

    @Override
    public boolean specify(Triangle triangle) {
        TriangleWarehouse warehouse = TriangleWarehouse.getInstance();
        long id = triangle.getId();
        TriangleProperty property =  warehouse.get(id);
        double area = property.getArea();
        boolean result = (area >= areaFrom && area <= areaTo);
        return result;
    }
}
