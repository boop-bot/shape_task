package edu.epam.task.entity;

public class TriangleProperty {
    private double perimeter;
    private double area;

    public TriangleProperty() {}

    public TriangleProperty(double perimeter, double area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
