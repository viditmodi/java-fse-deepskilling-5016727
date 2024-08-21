package com.api.BookstoreAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;

import com.api.BookstoreAPI.model.Book;
import com.api.BookstoreAPI.repository.BookRepository;

import lombok.Data;

@Service
@Data
public class BooksService {
    @Autowired
    private BookRepository bookRepository;
    
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookByID(int id){
        return bookRepository.findById(id);
    }

    public Book createNewBook(Book book){
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }
    public List<Book> getBookByQuery(String type, String query){
        List<Book> books = new ArrayList<Book>();
        if(type.equals("title")){
            books = bookRepository.getBooksByTitle(query);
        }
        else if(type.equals("author")){
            books = bookRepository.getBooksByAuthor(query);
        }
        return books;
    }

    public ResponseEntity<Book> updateBook(int id, Book book){
        Optional<Book> existingBook = bookRepository.findById(id);
        if(existingBook.isPresent()){
            Book foundBook = existingBook.get();
            foundBook.setAuthor(book.getAuthor());
            foundBook.setTitle(book.getTitle());
            foundBook.setIsbn(book.getIsbn());
            foundBook.setPrice(book.getPrice());
            Book updatedBook = bookRepository.save(foundBook);
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteBook(int id){
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}