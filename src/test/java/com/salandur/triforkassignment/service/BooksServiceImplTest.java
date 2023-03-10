package com.salandur.triforkassignment.service;

import com.salandur.triforkassignment.domain.Author;
import com.salandur.triforkassignment.domain.Book;
import com.salandur.triforkassignment.repositories.BooksRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BooksServiceImplTest {
    @Mock
    private BooksRepository booksRepository;

    private BooksService subject;

    @BeforeEach
    void setUp() {
        subject = new BooksServiceImpl(booksRepository);
    }

    @Test
    void getAllBooksShouldCallFindAllOnBooksRepository() {
        subject.getAllBooks();

        verify(booksRepository).findAll();
    }

    @Test
    void getBooksByTitleShouldCallFindAllByTitleOnBooksRepository() {
        subject.getBooksByTitle("title");

        verify(booksRepository).findAllByTitle("title");
    }

    @Test
    void getBookByIdShouldCallFindByIdOnBooksRepository() {
        subject.getBookById(1L);

        verify(booksRepository).findById(1L);
    }

    @Test
    void getBooksByAuthorShouldCallFindAllByAuthorOnBooksRepository() {
        Author author = new Author();
        author.setId(1L);

        subject.getBooksByAuthor(author);

        verify(booksRepository).findAllByAuthor(author);
    }

    @Test
    void createBookShouldCallSaveOnBooksRepository() {
        Book newBook = new Book();

        subject.createBook(newBook);

        verify(booksRepository).save(newBook);
    }

    @Test
    void saveBookShouldCallSaveOnBooksRepository() {
        Book book = new Book();

        subject.saveBook(book);

        verify(booksRepository).save(book);
    }
}