package com.example.demospringrestapi.repository;

import com.example.demospringrestapi.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);

//    SELECT * FROM practise WHERE name="Gospel" AND location="lagos"
    List<Employee> findByNameAndLocation(String name, String location);

//    SELECT * FROM practise WHERE name LIKE "%ram%"(This is mostly how to implement search functionality)
    List<Employee> findByNameContaining(String keyword, Sort sort);

    @Query("FROM  Employee WHERE name = :name OR location = :location")
    List<Employee> getEmployeesByNameAndLocation(String name, String location);

    @Transactional
    @Modifying
    @Query("DELETE FROM Employee WHERE name = :name")
    Integer deleteEmployeesByName(String name);
}
