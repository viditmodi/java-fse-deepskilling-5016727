package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
	private BookRepository books;

	public BookRepository getBooks() {
		return books;
	}

	public void setBooks(BookRepository books) {
		this.books = books;
	}
	
	
}
