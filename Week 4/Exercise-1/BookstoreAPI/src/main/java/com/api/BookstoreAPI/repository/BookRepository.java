package com.api.BookstoreAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.BookstoreAPI.model.Book;

@Repository
public interface BookRepository  extends JpaRepository<Book, Integer>{
    
}
