package edu.epam.task.util.comparator;

import edu.epam.task.entity.Triangle;

import java.util.Comparator;

public class IdComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
