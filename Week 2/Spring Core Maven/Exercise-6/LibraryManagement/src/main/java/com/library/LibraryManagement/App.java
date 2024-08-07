package com.library.LibraryManagement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to the Library" );
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService service = (BookService)context.getBean("bookService");
        service.getBooks().display();
    }
}
