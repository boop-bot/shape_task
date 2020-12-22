package edu.epam.task.util.comparator;

import edu.epam.task.entity.Triangle;

import java.util.Comparator;

public class SecondPointYComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        return Double.compare(o1.getB().getY(), o2.getB().getY());
    }
}
