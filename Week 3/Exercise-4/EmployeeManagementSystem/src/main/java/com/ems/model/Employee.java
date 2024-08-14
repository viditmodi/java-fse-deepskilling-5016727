package com.ems.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
    private Integer id;

	@Column(name = "employee_name")
    private String name;
	@Column(name = "employee_email")
	private String email;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;
    
    
    
    // public Long getId() {
	// 	return id;
	// }

	// public void setId(Long id) {
	// 	this.id = id;
	// }

	// public String getName() {
	// 	return name;
	// }

	// public void setName(String name) {
	// 	this.name = name;
	// }

	// public String getEmail() {
	// 	return email;
	// }

	// public void setEmail(String email) {
	// 	this.email = email;
	// }

	// public Department getDepartment() {
	// 	return department;
	// }

	// public void setDepartment(Department dept) {
	// 	this.department = dept;
	// }


}
