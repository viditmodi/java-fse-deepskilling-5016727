package com.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ems.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
    @Query(name = "Department.findByNameNamedQuery")
    List<Department> findByName(String name);
}
