package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
	private String name;
	private BookRepository books;
	
	public BookService(String name) {
		this.name = name;
	}

	public BookRepository getBooks() {
		return books;
	}

	public void setBooks(BookRepository books) {
		this.books = books;
	}
	
	public void display() {
		System.out.println(name);
		books.display();
	}
	
	
}
