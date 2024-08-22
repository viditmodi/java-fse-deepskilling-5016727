package com.api.BookstoreAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.BookstoreAPI.model.Book;
import com.api.BookstoreAPI.service.BooksService;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BooksService booksService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = booksService.getAllBooks();
        if(books.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(books);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(books);
        }
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Book> getBookByID(@PathVariable int id){
        Book book = booksService.getBookByID(id);
        if(book == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(book);
        }
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }
   
    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<Book>> getBookByQuery(@RequestParam("type") String type, @RequestParam("query") String query){
        List<Book> books = booksService.getBookByQuery(type, query);
        if(books.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(books);
        }
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = booksService.createNewBook(book);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "BookCreated");

        return ResponseEntity.status(HttpStatus.CREATED)
                             .headers(headers)
                             .body(savedBook);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book){
        Book updatedBook =  booksService.updateBook(id, book);
        if(updatedBook == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(updatedBook);
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteBook(@PathVariable int id){
        boolean isDeleted =  booksService.deleteBook(id);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
