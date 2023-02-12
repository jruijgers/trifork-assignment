package com.salandur.triforkassignment.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String pseudonym;
}
