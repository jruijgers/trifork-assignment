package com.salandur.triforkassignment.service;

import com.salandur.triforkassignment.domain.Author;
import com.salandur.triforkassignment.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorsServiceImpl implements AuthorsService {
    private final AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsServiceImpl(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }


    @Override
    public Optional<Author> getAuthorById(Long id) {
        return authorsRepository.findById(id);
    }
}
