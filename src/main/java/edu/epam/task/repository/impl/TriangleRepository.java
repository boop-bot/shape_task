package edu.epam.task.repository.impl;

import edu.epam.task.entity.Triangle;
import edu.epam.task.exception.RepositoryException;
import edu.epam.task.repository.Repository;
import edu.epam.task.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepository implements Repository<Triangle> {
    private static final TriangleRepository instance = new TriangleRepository();
    private final List<Triangle> triangles = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(TriangleRepository.class);

    private TriangleRepository(){}

    public static TriangleRepository getInstance() {
        return instance;
    }

    @Override
    public void add(Triangle triangle) throws RepositoryException {
        if (triangles.contains(triangle)) {
            throw new RepositoryException("Triangle already exists!");
        }
        triangles.add(triangle);
        logger.info(triangle + " added");
    }

    @Override
    public void remove(Triangle triangle) throws RepositoryException {
        if (!triangles.contains(triangle)) {
            throw new RepositoryException("Triangle not found");
        }
        triangles.remove(triangle);
        logger.info(triangle + " removed");
    }

    @Override
    public Triangle get(int index) throws RepositoryException{
        if (triangles.size() == 0) {
            throw new RepositoryException("Repository is empty");
        } else if (index < 0 || index >= triangles.size()) {
            throw new RepositoryException("Index out of range");
        }
        return triangles.get(index);
    }

    @Override
    public List<Triangle> sort(Comparator<Triangle> comparator) {
        List<Triangle> sortedList = triangles.stream().collect(Collectors.toList());
        sortedList.sort(comparator);
        logger.info("List: " + triangles + " sorted with comparator: " + comparator);
        return sortedList;
    }

    @Override
    public List<Triangle> query(Specification<Triangle> specification) {
        List<Triangle> resultList = triangles.stream().filter(o -> specification.specify(o)).collect(Collectors.toList());
        logger.info("Query with specification: " + specification + " and result list: " + resultList);
        return resultList;
    }
}
