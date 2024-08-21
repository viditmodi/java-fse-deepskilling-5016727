package com.api.BookstoreAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
// import org.springframework.web.bind.annotation.PathVariable;

import com.api.BookstoreAPI.model.Book;

@Repository
public interface BookRepository  extends JpaRepository<Book, Integer>{
    
    @Query("SELECT b FROM Book b WHERE b.title = :query")
    public List<Book> getBooksByTitle(@Param("query") String query);

    @Query("SELECT b FROM Book b WHERE b.author = :query")
    public List<Book> getBooksByAuthor(@Param("query") String query);
}
