package edu.epam.task.util.comparator;

import edu.epam.task.entity.Triangle;

import java.util.Comparator;

public class SecondPointXComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        return Double.compare(o1.getB().getX(), o2.getB().getX());
    }
}
