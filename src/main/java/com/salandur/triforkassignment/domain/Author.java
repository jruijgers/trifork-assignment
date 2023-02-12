package com.salandur.triforkassignment.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Author {
    @EqualsAndHashCode.Include
    private Long id;

    @EqualsAndHashCode.Exclude
    private String name;

    @EqualsAndHashCode.Exclude
    private String pseudonym;
}
