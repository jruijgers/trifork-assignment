package com.salandur.triforkassignment.service;

import com.salandur.triforkassignment.repositories.BooksRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BooksServiceTest {
    @Mock
    private BooksRepository booksRepository;

    private BooksService subject;

    @BeforeEach
    void setUp() {
        subject = new BooksService(booksRepository);
    }

    @Test
    void getAllBooksShouldCallFindAllOnBooksRepository() {
        subject.getAllBooks();

        verify(booksRepository).findAll();
    }

    @Test
    void getBookByIdShouldCallFindByIdOnBooksRepository() {
        subject.getBookById(1L);

        verify(booksRepository).findById(1L);
    }
}