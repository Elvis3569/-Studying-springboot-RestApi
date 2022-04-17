package com.example.demospringrestapi.service;

import com.example.demospringrestapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployee(int pageNo, int pageSize);

    Employee saveEmployee(Employee employee);
    Employee getEmployee(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee employee);
    List<Employee> getEmployeeByName(String name);
    List<Employee> getEmployeeByNameAndLocation(String name, String location);
    List<Employee> getEmployeeByKeyword(String name);
    List<Employee> getEmployeeByNameORLocation(String name, String location);
    Integer deleteByEmployeeName (String name);
}
