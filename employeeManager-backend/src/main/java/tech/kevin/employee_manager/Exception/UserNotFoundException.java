package tech.kevin.employee_manager.Exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String s) {
        super(s);
    }
}
