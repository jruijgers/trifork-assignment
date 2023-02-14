package com.salandur.triforkassignment.service;

import com.salandur.triforkassignment.repositories.AuthorsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AuthorsServiceImplTest {
    @Mock
    private AuthorsRepository authorsRepository;

    private AuthorsServiceImpl subject;

    @BeforeEach
    public void setUp() {
        subject = new AuthorsServiceImpl(authorsRepository);
    }

    @Test
    void getAuthorByIdShouldCallFindByIdOnAuthorsRepository() {
        subject.getAuthorById(1L);

        verify(authorsRepository).findById(1L);
    }
}