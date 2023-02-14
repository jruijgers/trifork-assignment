package com.salandur.triforkassignment.service;

import com.salandur.triforkassignment.domain.Book;

import java.util.Optional;

public interface BooksService {
    Iterable<Book> getAllBooks();

    Iterable<Book> getBooksByTitle(String title);

    Optional<Book> getBookById(Long id);

    Book createBook(Book newBook);

    Book saveBook(Book book);


}
