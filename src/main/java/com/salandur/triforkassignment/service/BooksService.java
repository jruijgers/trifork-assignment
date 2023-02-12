package com.salandur.triforkassignment.service;

import com.salandur.triforkassignment.domain.Book;
import com.salandur.triforkassignment.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
    @Autowired
    private BooksRepository booksRepository;

    public Iterable<Book> getAllBooks() {
        return booksRepository.findAll();
    }
}
