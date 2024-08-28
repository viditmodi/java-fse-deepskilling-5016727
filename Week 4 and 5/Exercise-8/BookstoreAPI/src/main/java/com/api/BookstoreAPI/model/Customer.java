package com.api.BookstoreAPI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int id;
    @Column(name="customer_name", nullable = false)
    private String name;
    @Column(name="customer_email", nullable = false, unique = true)
    private String email;
    @Column(name="customer_address", nullable = false)
    private String address;


}
