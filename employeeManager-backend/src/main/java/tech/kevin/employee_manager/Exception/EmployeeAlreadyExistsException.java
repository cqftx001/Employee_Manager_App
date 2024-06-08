package tech.kevin.employee_manager.Exception;

public class EmployeeAlreadyExistsException extends RuntimeException{
    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }
}
