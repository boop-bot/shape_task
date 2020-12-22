package edu.epam.task.entity;

import edu.epam.task.observer.Observable;
import edu.epam.task.observer.Observer;
import edu.epam.task.observer.impl.TriangleObserver;
import edu.epam.task.util.idgenerator.IdGenerator;

public class Triangle extends Shape implements Observable<TriangleObserver> {
    private long id = IdGenerator.generateId();
    private Point a;
    private Point b;
    private Point c;
    private Observer<Triangle> observer;

    public Triangle() {
        a = new Point();
        b = new Point();
        c = new Point();
    }

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
        notifyObserver();
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
        notifyObserver();
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
        notifyObserver();
    }

    public long getId() {
        return id;
    }

    @Override
    public void attach(TriangleObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detach(TriangleObserver triangleObserver) {
        this.observer = null;
    }

    @Override
    public void notifyObserver() {
        if(observer != null) {
            observer.performedArea(this);
            observer.performedPerimeter(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (!a.equals(triangle.a)) return false;
        if (!b.equals(triangle.b)) return false;
        return c.equals(triangle.c);
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + b.hashCode();
        result = 31 * result + c.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append("id=").append(id);
        sb.append(", a=").append(a);
        sb.append(", b=").append(b);
        sb.append(", c=").append(c);
        sb.append('}');
        return sb.toString();
    }
}
