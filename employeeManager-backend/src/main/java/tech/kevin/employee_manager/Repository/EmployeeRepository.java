package tech.kevin.employee_manager.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.kevin.employee_manager.Model.Employee;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findEmployeeById(String id);

    Optional<Employee> findByEmail(String email);
}
