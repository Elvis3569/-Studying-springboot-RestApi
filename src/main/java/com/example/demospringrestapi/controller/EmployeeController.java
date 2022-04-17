package com.example.demospringrestapi.controller;

import com.example.demospringrestapi.model.Employee;
import com.example.demospringrestapi.service.serviceImp.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<?> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(employeeServiceImp.getEmployee(pageNumber,pageSize), HttpStatus.OK);
    }
    @GetMapping("/employee/filterByName")
    public ResponseEntity<?> getEmployeeByName(@RequestParam String name) {
        return new ResponseEntity<>(employeeServiceImp.getEmployeeByName(name), HttpStatus.OK);
    }

    @GetMapping("/employee/{name}/{location}")
    public ResponseEntity<?> getEmployeeByNameOrLocation(@PathVariable String name, @PathVariable String location) {
        return new ResponseEntity<>(employeeServiceImp.getEmployeeByNameORLocation(name, location), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployees(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeServiceImp.getEmployee(id), HttpStatus.FOUND);
    }
    @GetMapping("/employee/filterByNameAndLocation")
    public ResponseEntity<?> getByNameAndLocation(@RequestParam String name, @RequestParam String location){
        return new ResponseEntity<>(employeeServiceImp.getEmployeeByNameAndLocation(name, location), HttpStatus.OK);
    }

    @GetMapping("/employee/filterByKeyword")
    public ResponseEntity<?> getByKeyword(@RequestParam String name){
        return new ResponseEntity<>(employeeServiceImp.getEmployeeByKeyword(name), HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeServiceImp.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return new ResponseEntity<>(employeeServiceImp.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/employees")
    public ResponseEntity<?> deleteEmployees(@RequestParam("id") Long id) {
        employeeServiceImp.deleteEmployee(id);
        return new ResponseEntity<>("Employee has been deleted",HttpStatus.OK);
    }

    @DeleteMapping("/employees/delete/{name}")
    public ResponseEntity<?> deleteEmployeesByName(@PathVariable String name) {
        return new ResponseEntity<>(employeeServiceImp.deleteByEmployeeName(name),HttpStatus.OK);
//        return new ResponseEntity<>("No of Methods deleted",HttpStatus.OK);
    }
}
