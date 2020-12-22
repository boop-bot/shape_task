package edu.epam.task.exception;

public class TriangleParserException extends Exception {
    public TriangleParserException() {
        super();
    }

    public TriangleParserException(String message) {
        super(message);
    }

    public TriangleParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
