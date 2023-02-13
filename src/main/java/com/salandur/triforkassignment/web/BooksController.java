package com.salandur.triforkassignment.web;

import com.salandur.triforkassignment.domain.Book;
import com.salandur.triforkassignment.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BooksController {
    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return booksService.getAllBooks();
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book newBook) {
        return booksService.createBook(newBook);
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return booksService.getBookById(id);
    }
}
