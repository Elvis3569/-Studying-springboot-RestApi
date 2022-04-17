package com.example.demospringrestapi.service.serviceImp;

import com.example.demospringrestapi.model.Employee;
import com.example.demospringrestapi.repository.EmployeeRepository;
import com.example.demospringrestapi.service.EmployeeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeeByKeyword(String name) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return employeeRepository.findByNameContaining(name, sort);
    }

    @Override
    public List<Employee> getEmployeeByNameAndLocation(String name, String location) {
        return employeeRepository.findByNameAndLocation(name, location);
    }

    @Override
    public List<Employee> getEmployee(int pageNo, int pageSize) {
        Pageable pages = PageRequest.of(pageNo,pageSize, Sort.Direction.DESC, "id");
       return employeeRepository.findAll(pages).toList();
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
       Optional<Employee> employee = employeeRepository.findById(id);
       if(employee.isPresent()) {
           return employee.get();
       }
       throw new RuntimeException("Employee is not found for the id"+id);
    }

    @Override
    public List<Employee> getEmployeeByNameORLocation(String name, String location) {
        return employeeRepository.getEmployeesByNameAndLocation(name, location);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Integer deleteByEmployeeName(String name) {
        return employeeRepository.deleteEmployeesByName(name);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
