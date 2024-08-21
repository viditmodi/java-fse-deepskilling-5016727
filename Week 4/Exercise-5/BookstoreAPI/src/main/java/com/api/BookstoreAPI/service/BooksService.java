package com.api.BookstoreAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

    public Book getBookByID(int id){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            Book foundBook = book.get();
            return foundBook;
        }
        else{
            return null;
        }
    }

    public Book createNewBook(Book book){
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }
    
    public List<Book> getBookByQuery(String type, String query){
        List<Book> books = null;
        if(type.equals("title")){
            books = bookRepository.getBooksByTitle(query);
        }
        else if(type.equals("author")){
            books = bookRepository.getBooksByAuthor(query);
        }
        return books;
    }

    public Book updateBook(int id, Book book){
        Optional<Book> existingBook = bookRepository.findById(id);
        if(existingBook.isPresent()){
            Book foundBook = existingBook.get();
            foundBook.setAuthor(book.getAuthor());
            foundBook.setTitle(book.getTitle());
            foundBook.setIsbn(book.getIsbn());
            foundBook.setPrice(book.getPrice());
            Book updatedBook = bookRepository.save(foundBook);
            return updatedBook;
        } else {
            return null;
        }
    }

    public boolean deleteBook(int id){
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}