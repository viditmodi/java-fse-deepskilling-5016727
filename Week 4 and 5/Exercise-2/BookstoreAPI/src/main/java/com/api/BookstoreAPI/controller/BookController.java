package com.api.BookstoreAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.BookstoreAPI.model.Book;
import com.api.BookstoreAPI.service.BooksService;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BooksService booksService;

    @GetMapping
    public List<Book> getAllBooks(){
        return booksService.getAllBooks();
    }
    @GetMapping("/{id}")
    public Optional<Book> getBookByID(@PathVariable int id){
        return booksService.getBookByID(id);
    }

    @PostMapping
    public Book createNewBook(@RequestBody Book book){
        return booksService.createNewBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book){
        return booksService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id){
        return booksService.deleteBook(id);
    }
}
