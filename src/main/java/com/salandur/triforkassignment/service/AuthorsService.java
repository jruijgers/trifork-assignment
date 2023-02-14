package com.salandur.triforkassignment.service;

import com.salandur.triforkassignment.domain.Author;

import java.util.Optional;

public interface AuthorsService {

    Optional<Author> getAuthorById(Long id);
}
