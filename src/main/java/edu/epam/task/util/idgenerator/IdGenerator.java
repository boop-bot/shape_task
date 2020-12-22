package edu.epam.task.util.idgenerator;

public class IdGenerator {
    private static long id = 0;

    public static long generateId(){
        return ++id;
    }
}
