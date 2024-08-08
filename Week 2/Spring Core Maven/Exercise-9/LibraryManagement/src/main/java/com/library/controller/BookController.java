package com.library.controller;


import org.springframework.web.bind.annotation.*;

import com.library.model.Book;



@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String getAllBooks() {
        return "Fetching All Books";
    }

    
    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id) {
        return "Fetching Book with ID: "+id;
    }

    @PostMapping
    public String createBook(@RequestBody Book book) {
    	return "Creating Book\n"+book;
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable Long id, @RequestBody Book book) {
    	return "Updating Book with ID: "+id+"\n"+book;
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        return "Deleteing Book with ID: "+id;
    }
}
