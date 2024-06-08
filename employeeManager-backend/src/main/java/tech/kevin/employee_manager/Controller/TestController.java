package tech.kevin.employee_manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.kevin.employee_manager.Model.Employee;
import tech.kevin.employee_manager.Repository.EmployeeRepository;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/test/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/test/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
