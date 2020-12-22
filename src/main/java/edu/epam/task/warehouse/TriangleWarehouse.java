package edu.epam.task.warehouse;

import edu.epam.task.entity.TriangleProperty;

import java.util.HashMap;
import java.util.Map;

public class TriangleWarehouse {
    private Map<Long, TriangleProperty> properties = new HashMap<>();
    private static final TriangleWarehouse instance = new TriangleWarehouse();

    private TriangleWarehouse() {}

    public static TriangleWarehouse getInstance() {
        return instance;
    }

    public TriangleProperty get(long id) {
        TriangleProperty propertyCopy = new TriangleProperty(properties.get(id).getPerimeter(), properties.get(id).getArea());
        return propertyCopy;
    }

    public void put(long id, TriangleProperty tp) {
        properties.put(id,tp);
    }

    public boolean containsProperty(long id){
        return properties.containsKey(id);
    }

}
