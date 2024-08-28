package com.api.BookstoreAPI.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", unique = true, nullable = false)
    private int id;
    @Column(name = "book_title", nullable = false)
    private String title;
    @Column(name = "book_author", nullable = false)
    private String author;
    @Column(name = "book_price", nullable = false)
    private int price;
    @Column(name = "book_isbn", unique = true, nullable = false)
    private int isbn;
}
