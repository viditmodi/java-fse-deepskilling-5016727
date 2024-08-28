package com.api.BookstoreAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.BookstoreAPI.model.Book;

@Repository
public interface BookRepository  extends JpaRepository<Book, Integer>{
}
