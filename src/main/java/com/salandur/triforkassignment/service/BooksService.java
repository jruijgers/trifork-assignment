package com.salandur.triforkassignment.service;

import com.salandur.triforkassignment.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BooksService {
    @Transactional(readOnly = true)
    Iterable<Book> getAllBooks();

    @Transactional(readOnly = true)
    Optional<Book> getBookById(Long id);

    @Transactional
    Book createBook(Book newBook);
}
