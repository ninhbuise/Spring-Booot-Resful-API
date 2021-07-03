package com.example.RestAPI.restController;

import java.util.List;

import com.example.RestAPI.entity.Employee;
import com.example.RestAPI.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    private final EmployeeService employeeService;
    
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    
    @GetMapping("/list")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    };

    @GetMapping("/emp/{id}")
    public Employee findEmployeeById(@PathVariable int id){
        return employeeService.findEmployeeById(id);
    };
    
    @PostMapping("/emp")
    public Employee addNewEmployee(@RequestBody Employee newEmpl){
        return employeeService.addNewEmployee(newEmpl);
    }

    @PutMapping("/emp/{id}")
    public Employee updateEmployee(@RequestBody Employee newEmpl, @PathVariable int id){
        return employeeService.updateEmployee(newEmpl, id);
    }

    @DeleteMapping("/emp/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }
}
