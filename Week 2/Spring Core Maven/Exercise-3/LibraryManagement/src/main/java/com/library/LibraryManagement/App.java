package com.library.LibraryManagement;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App 
{
	  public static void main(String[] args) {
		  
		  System.out.println("Welcome to the Library.");
	        
	        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	        
	        BookService bookService = (BookService) context.getBean("bookService");

	        
	        bookService.getRepo().display();
    }
}
