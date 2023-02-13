package com.salandur.triforkassignment.web;

import com.salandur.triforkassignment.domain.Book;
import com.salandur.triforkassignment.service.BooksService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    void createBookShouldCallCreateBookOnBooksService() {
        Book newBook = new Book();

        subject.createBook(newBook);

        verify(booksService).createBook(newBook);
    }

    @Test
    void updateBookShouldCallUpdateBookOnBooksService() {
        Book existingBook = new Book();
        existingBook.setId(1L);
        when(booksService.getBookById(anyLong())).thenReturn(Optional.of(existingBook));
        when(booksService.saveBook(any())).thenReturn(existingBook);

        Book updateBook = new Book();

        subject.updateBook(updateBook, 1L);

        verify(booksService).saveBook(existingBook);
    }

    @Test
    void updateBookShouldUpdateTitleOfExistingBook() {
        Book existingBook = new Book();
        existingBook.setId(1L);
        when(booksService.getBookById(1L)).thenReturn(Optional.of(existingBook));
        when(booksService.saveBook(any())).thenReturn(existingBook);

        Book updateBook = new Book();
        updateBook.setName("new title");

        subject.updateBook(updateBook, 1L);

        assertEquals("new title", existingBook.getName(), "title does not match");
    }
}