package com.salandur.triforkassignment.service;

import com.salandur.triforkassignment.domain.Book;
import com.salandur.triforkassignment.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BooksService {
    @Autowired
    private BooksRepository booksRepository;

    @Transactional(readOnly = true)
    public Iterable<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Book> getBookById(Long id) {
        return booksRepository.findById(id);
    }
}
