package com.example.RestAPI.service;

import java.util.List;

import com.example.RestAPI.entity.Employee;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public Employee findEmployeeById(int id);
    public Employee addNewEmployee(Employee newEmpl);
    public Employee updateEmployee(Employee newEmpl, int id);
    public void deleteEmployee(int id);
}
