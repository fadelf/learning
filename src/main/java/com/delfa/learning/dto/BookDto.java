package com.delfa.learning.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String genre;
    private Double price;
}
