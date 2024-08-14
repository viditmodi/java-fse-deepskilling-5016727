package com.ems.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ems.model.Department;
import com.ems.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    List<Employee> findByDepartment(Department dept);

    @Override
    Page<Employee> findAll(Pageable page);

    @Query(name= "Employee.findByEmailNamedQuery")
    Employee findByEmail(@Param("email") String email);
    
    @Query(name= "Employee.findByNameNamedQuery")
    Page<Employee> findByName(@Param("name") String name, Pageable page);

}
