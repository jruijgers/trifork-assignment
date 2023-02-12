package com.salandur.triforkassignment.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
public class Book {
    @EqualsAndHashCode.Include
    private Long id;

    @EqualsAndHashCode.Exclude
    private String name;

    @EqualsAndHashCode.Exclude
    private Author author;

    @EqualsAndHashCode.Exclude
    private String description;

    @EqualsAndHashCode.Exclude
    private String coverImage;

    @EqualsAndHashCode.Exclude
    private Double price;
}
