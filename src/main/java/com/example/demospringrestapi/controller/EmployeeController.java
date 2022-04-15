package com.example.demospringrestapi.controller;

import com.example.demospringrestapi.model.Employee;
import com.example.demospringrestapi.service.serviceImp.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//localhost:8080/api/v1/employees

@RestController
public class EmployeeController {

//    @Value("${app.name}")
//    private String appName;
//
//    @Value("${app.version}")
//    private String appVersion;


//    @GetMapping("/version")
//    public String getAppDetails () {
//        return appName + " - " + appVersion;
//    }
    public final EmployeeServiceImp employeeServiceImp;

    public EmployeeController(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }


    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeServiceImp.getEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployees(@PathVariable("id") Long id) {
        return employeeServiceImp.getEmployee(id);
    }
    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeServiceImp.saveEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeServiceImp.updateEmployee(employee);
    }

    @DeleteMapping("/employees")
    public void deleteEmployees(@RequestParam("id") Long id) {
        employeeServiceImp.deleteEmployee(id);
    }
}
