package com.salandur.triforkassignment.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String title;

    @ManyToOne
    @NotBlank
    private Author author;

    @NotBlank
    private String description;

    private String coverImage;

    @NotBlank
    private Double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
