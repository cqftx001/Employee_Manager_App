package tech.kevin.employee_manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.kevin.employee_manager.Model.Employee;
import tech.kevin.employee_manager.Service.EmployeeService;
import tech.kevin.employee_manager.Service.FileStorageService;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.kevin.employee_manager.Model.Employee;
import tech.kevin.employee_manager.Service.EmployeeService;
import tech.kevin.employee_manager.Service.FileStorageService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final FileStorageService fileStorageService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, FileStorageService fileStorageService) {
        this.employeeService = employeeService;
        this.fileStorageService = fileStorageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String id, @RequestBody Employee employeeDetails) {
        Employee employeeUpdated = employeeService.updateEmployee(id, employeeDetails);
        return new ResponseEntity<>(employeeUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") String id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileUrl = fileStorageService.storeFile(file);
        return new ResponseEntity<>(fileUrl, HttpStatus.OK);
    }
}
