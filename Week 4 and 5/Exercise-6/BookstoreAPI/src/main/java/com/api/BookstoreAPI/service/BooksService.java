package com.api.BookstoreAPI.service;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;

import com.api.BookstoreAPI.exception.InvalidRequestException;
import com.api.BookstoreAPI.exception.ResourceNotFoundException;
import com.api.BookstoreAPI.model.Book;
import com.api.BookstoreAPI.repository.BookRepository;

import lombok.Data;

@Service
@Data
public class BooksService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookByID(int id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
        return book;
    }

    public Book createNewBook(Book book) {
        if (!book.isValid()) {
            throw new InvalidRequestException("Invalid Book Data");
        }
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }

    public List<Book> getBookByQuery(String type, String query) {
        List<Book> books = null;
        if (type.equals("title")) {
            books = bookRepository.getBooksByTitle(query);
        } else if (type.equals("author")) {
            books = bookRepository.getBooksByAuthor(query);
        } else {
            throw new InvalidRequestException("Invalid Param type");
        }
        return books;
    }

    public Book updateBook(int id, Book book) {
        Book foundBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));

        if (!book.isValid()) {
            throw new InvalidRequestException("Invalid Book Data");
        }
        foundBook.setAuthor(book.getAuthor());
        foundBook.setTitle(book.getTitle());
        foundBook.setIsbn(book.getIsbn());
        foundBook.setPrice(book.getPrice());
        Book updatedBook = bookRepository.save(foundBook);
        return updatedBook;

    }

    public boolean deleteBook(int id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}