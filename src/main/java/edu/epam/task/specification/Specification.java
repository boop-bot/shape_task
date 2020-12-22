package edu.epam.task.specification;

public interface Specification<T> {
    boolean specify(T t);
}
