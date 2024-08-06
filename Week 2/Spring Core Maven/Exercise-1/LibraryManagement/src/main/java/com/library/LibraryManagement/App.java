package com.library.LibraryManagement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.repository.BookRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to the Library." );
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        BookRepository br = (BookRepository)context.getBean("repo");
        br.displayBooks();
    }
}
