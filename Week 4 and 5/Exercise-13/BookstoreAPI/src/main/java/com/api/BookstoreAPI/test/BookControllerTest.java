package com.api.BookstoreAPI.test;

import com.api.BookstoreAPI.controller.BookController;
import com.api.BookstoreAPI.service.BooksService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BooksService bookService;

    @InjectMocks
    private BookController bookController;

    @Test
    public void testGetBookById() throws Exception {
        // Example of mocking a service method
        when(bookService.getBookById(1L)).thenReturn(new Book(1L, "Test Book", "Test Author"));

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Book"))
                .andExpect(jsonPath("$.author").value("Test Author"));

        verify(bookService, times(1)).getBookById(1L);
    }

    // Add more test methods here...
}
