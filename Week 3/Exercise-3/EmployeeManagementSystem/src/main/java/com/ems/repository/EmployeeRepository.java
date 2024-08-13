package com.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.model.Department;
import com.ems.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    List<Employee> findByName(String name);
    List<Employee> findByDepartment(Department dept);
    Employee findByEmail(String email);
}
