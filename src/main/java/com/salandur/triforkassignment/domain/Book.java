package com.salandur.triforkassignment.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Author author;

    private String description;

    private String coverImage;

    private Double price;
}
