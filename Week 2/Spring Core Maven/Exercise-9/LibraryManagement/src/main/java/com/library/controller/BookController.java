package com.library.controller;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks() {
    	System.out.println("All Books");
        return bookRepository.findAll();
    }
//    @GetMapping
//    public String getAllBooks() {
//        return "All Books";
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
//    @GetMapping("/{id}")
//    public Long getBookById(@PathVariable Long id) {
//        return id;
//    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                    existingBook.setTitle(book.getTitle());
                    existingBook.setAuthor(book.getAuthor());
                    Book updatedBook = bookRepository.save(existingBook);
                    return ResponseEntity.ok(updatedBook);
                })
                .orElse(ResponseEntity.notFound().build());
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
//        return bookRepository.findById(id)
//                .map(existingBook -> {
//                    bookRepository.delete(existingBook);
//                    return ResponseEntity.noContent().build();
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
}
