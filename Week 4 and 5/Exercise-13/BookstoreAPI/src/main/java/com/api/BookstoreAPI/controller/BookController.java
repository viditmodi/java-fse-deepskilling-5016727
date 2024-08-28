package com.api.BookstoreAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.api.BookstoreAPI.dto.BookDTO;
import com.api.BookstoreAPI.model.Book;
import com.api.BookstoreAPI.service.BooksService;
import com.api.BookstoreAPI.config.CustomMetrics;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BooksService booksService;
    @Autowired
    private CustomMetrics customMetrics;

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = booksService.getAllBooks();
        if(books.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(books);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(books);
        }
    }
    
    @GetMapping(value="/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookDTO> getBookByID(@PathVariable int id){
        BookDTO bookDTO = booksService.getBookByID(id);
        if(bookDTO == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookDTO);
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

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
    produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BookDTO> createBook(@RequestBody Book book) {
        BookDTO savedBook = booksService.createNewBook(book);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "BookCreated");
        customMetrics.incrementBookCreationCounter();

        return ResponseEntity.status(HttpStatus.CREATED)
                             .headers(headers)
                             .body(savedBook);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookDTO> updateBook(@PathVariable int id, @RequestBody Book book){
        BookDTO updatedBook =  booksService.updateBook(id, book);
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
