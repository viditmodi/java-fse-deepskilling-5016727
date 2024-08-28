package com.api.BookstoreAPI.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.BookstoreAPI.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
