package com.example.RestAPI.service.impl;

import java.util.List;

import com.example.RestAPI.entity.Employee;
import com.example.RestAPI.exception.EmployeeNotFoundException;
import com.example.RestAPI.repository.EmployeeRepository;
import com.example.RestAPI.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeRepository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public Employee addNewEmployee(Employee newEmpl) {
        return employeeRepository.save(newEmpl);
    }

    @Override
    public Employee updateEmployee(Employee newEmpl, int id) {
        return employeeRepository.findById(id)
            .map(employee -> {
                employee.setFirst_name(newEmpl.getFirst_name());
                employee.setLast_name(newEmpl.getLast_name());
                employee.setDepartment(newEmpl.getDepartment());
                employee.setJob_title(newEmpl.getJob_title());
                employee.setBirthday(newEmpl.getBirthday());
                employee.setEmail(newEmpl.getEmail());
                employee.setPhone(newEmpl.getPhone());
                return employeeRepository.save(employee);
            })
            .orElseGet(()->{
                return employeeRepository.save(newEmpl);
            }
        );
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
    
}
