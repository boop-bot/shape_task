package edu.epam.task.observer;

import edu.epam.task.entity.Shape;

public interface Observer<T extends Shape> {
    void performedPerimeter(T t);
    void performedArea(T t);
}
