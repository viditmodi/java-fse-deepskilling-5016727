package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
	private BookRepository repo;
	
	public void setRepo(BookRepository repo) {
		this.repo = repo;
	}
	
	public BookRepository getRepo() {
		return this.repo;
	}
}
