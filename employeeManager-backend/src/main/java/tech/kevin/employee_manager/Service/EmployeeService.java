package tech.kevin.employee_manager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.kevin.employee_manager.Exception.EmployeeAlreadyExistsException;
import tech.kevin.employee_manager.Exception.UserNotFoundException;
import tech.kevin.employee_manager.Model.Employee;
import tech.kevin.employee_manager.Repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findByEmail(employee.getEmail());
        if (existingEmployee.isPresent()) {
            throw new EmployeeAlreadyExistsException("The employee " + employee.getName() + " is already existed!");
        }
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(String id) {
        return employeeRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id '" + id + '\'' + " was not found!"));
    }

    public Employee updateEmployee(String id, Employee employeeDetails) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(employeeDetails.getName());
            employee.setEmail(employeeDetails.getEmail());
            employee.setJobTitle(employeeDetails.getJobTitle());
            employee.setPhoneNumber(employeeDetails.getPhoneNumber());
            employee.setImgURL(employeeDetails.getImgURL());
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new UserNotFoundException("User with id '" + id + '\'' + " was not found!"));
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
