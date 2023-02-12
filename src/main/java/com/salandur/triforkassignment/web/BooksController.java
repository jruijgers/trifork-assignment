package com.salandur.triforkassignment.web;

import com.salandur.triforkassignment.domain.Book;
import com.salandur.triforkassignment.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return booksService.getAllBooks();
    }
}
