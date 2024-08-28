package com.api.BookstoreAPI.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BookDTO extends RepresentationModel<BookDTO>{
    // private Long id;
    private String title;
    private String author;
    private String isbn;

}
