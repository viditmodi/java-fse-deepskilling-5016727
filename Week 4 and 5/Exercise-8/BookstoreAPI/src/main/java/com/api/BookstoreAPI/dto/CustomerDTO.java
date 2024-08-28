package com.api.BookstoreAPI.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerDTO extends RepresentationModel<CustomerDTO>{
    private String name;
    private String email;
    private String address;

}
