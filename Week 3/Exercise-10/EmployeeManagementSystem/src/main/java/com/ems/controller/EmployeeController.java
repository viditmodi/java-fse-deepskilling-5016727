package com.ems.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ems.model.Employee;
import com.ems.projection.EmployeeProjection;
import com.ems.repository.EmployeeRepository;

// import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public Page<Employee> getAllEmployees(Pageable page) {
        return employeeRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email")
    public Employee getEmployeeByEmail(@RequestParam String email){
        Employee employee = employeeRepository.findByEmail(email);
        return employee;
    }

    @GetMapping("/name")
    public Page<Employee> getEmployeeByName(@RequestParam String name, Pageable page){
        Page<Employee> employee = employeeRepository.findByName(name, page);
        return employee;
    }
    @GetMapping("/dept")
    public Page<EmployeeProjection> getEmployeeByDeptName(@RequestParam String dept, Pageable page){
        Page<EmployeeProjection> employee = employeeRepository.findEmployeeProjectionsByDepartmentName(dept, page);
        return employee;
    }
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            Employee existingEmployee = employee.get();
            existingEmployee.setName(employeeDetails.getName());
            existingEmployee.setEmail(employeeDetails.getEmail());
            existingEmployee.setDepartment(employeeDetails.getDepartment());
            Employee updatedEmployee = employeeRepository.save(existingEmployee);
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}