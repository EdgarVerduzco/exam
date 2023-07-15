package exam.everduzco.springboot.app.everduzco.models;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}