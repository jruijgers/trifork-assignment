package com.salandur.triforkassignment.service;

import com.salandur.triforkassignment.domain.Book;
import com.salandur.triforkassignment.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Book> getBooksByTitle(String title) {
        return booksRepository.findAllByTitle(title);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Book> getBookById(Long id) {
        return booksRepository.findById(id);
    }

    @Override
    @Transactional
    public Book createBook(Book newBook) {
        return booksRepository.save(newBook);
    }

    @Override
    @Transactional
    public Book saveBook(Book book) {
        return booksRepository.save(book);
    }
}
