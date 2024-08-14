package com.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ems.model.Department;
import com.ems.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    // List<Employee> findByName(String name);
    List<Employee> findByDepartment(Department dept);
    // Employee findByEmail(String email);

    @Query(name= "Employee.findByEmailNamedQuery")
    Employee findByEmail(@Param("email") String email);
    
    @Query(name= "Employee.findByNameNamedQuery")
    List<Employee> findByName(@Param("name") String name);


    // List<Employee> findByNameNamedQuery(@Param("name") String name);

    // List<Employee> findAllNamedQuery();
}
