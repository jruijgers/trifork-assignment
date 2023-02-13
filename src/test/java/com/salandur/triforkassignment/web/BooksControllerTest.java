package com.salandur.triforkassignment.web;

import com.salandur.triforkassignment.service.BooksService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BooksControllerTest {

    @Mock
    private BooksService booksService;

    private BooksController subject;

    @BeforeEach
    void setUp() {
        subject = new BooksController(booksService);
    }

    @Test
    void getBooksShouldCallGetAllBooksOnBooksService() {
        subject.getBooks();

        verify(booksService).getAllBooks();
    }

    @Test
    void getBookByIdShouldCallGetBookByIdOnBooksService() {
        subject.getBookById(1L);

        verify(booksService).getBookById(1L);
    }
}