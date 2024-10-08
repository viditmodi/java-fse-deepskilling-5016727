package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository books;

	public BookRepository getBooks() {
		return books;
	}

	public void setBooks(BookRepository books) {
		this.books = books;
	}
	
}
