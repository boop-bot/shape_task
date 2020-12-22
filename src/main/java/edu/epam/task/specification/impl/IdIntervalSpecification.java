package edu.epam.task.specification.impl;

import edu.epam.task.entity.Triangle;
import edu.epam.task.specification.Specification;

public class IdIntervalSpecification implements Specification<Triangle> {
    private long idFrom;
    private long idTo;

    public IdIntervalSpecification(long idFrom, long idTo) {
        this.idFrom = idFrom;
        this.idTo = idTo;
    }

    @Override
    public boolean specify(Triangle triangle) {
        long id = triangle.getId();
        boolean result = (id >= idFrom && id <= idTo);
        return result;
    }
}
