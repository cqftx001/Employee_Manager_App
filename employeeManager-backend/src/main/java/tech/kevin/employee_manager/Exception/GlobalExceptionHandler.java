package tech.kevin.employee_manager.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<String> handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorrectResultSizeDataAccessException.class)
    public ResponseEntity<String> handleIncorrectResultSizeDataAccessException(IncorrectResultSizeDataAccessException ex) {
        return new ResponseEntity<>("Multiple employees found with the same email. Please ensure email uniqueness.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
