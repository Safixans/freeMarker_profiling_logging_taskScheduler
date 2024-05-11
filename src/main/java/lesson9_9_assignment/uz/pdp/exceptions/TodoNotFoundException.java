package lesson9_9_assignment.uz.pdp.exceptions;

public class TodoNotFoundException extends RuntimeException{
    public TodoNotFoundException(String message) {
        super(message);
    }
}
