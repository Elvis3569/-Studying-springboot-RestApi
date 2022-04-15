package com.example.demospringrestapi.service;

import com.example.demospringrestapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployee();

    Employee saveEmployee(Employee employee);
    Employee getEmployee(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee employee);
}
