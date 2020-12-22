package edu.epam.task.observer;

public interface Observable<T> {
    void attach(T t);
    void detach(T t);
    void notifyObserver();
}
