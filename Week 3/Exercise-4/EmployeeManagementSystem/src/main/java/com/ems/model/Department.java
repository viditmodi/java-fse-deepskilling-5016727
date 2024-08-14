package com.ems.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "departments")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
    private Integer id;
	@Column(name = "department_name")
    private String name;
    
    
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
    
    
}
