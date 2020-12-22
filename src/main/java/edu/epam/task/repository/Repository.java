package edu.epam.task.repository;

import edu.epam.task.entity.Shape;
import edu.epam.task.exception.RepositoryException;
import edu.epam.task.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T extends Shape> {
    void add(T t) throws RepositoryException;
    void remove(T t) throws RepositoryException;
    T get(int index) throws RepositoryException;
    List<T> sort(Comparator<T> comparator) throws RepositoryException;
    List<T> query(Specification<T> specification) throws RepositoryException;
}
