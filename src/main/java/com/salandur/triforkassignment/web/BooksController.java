package com.salandur.triforkassignment.web;

import com.salandur.triforkassignment.domain.Author;
import com.salandur.triforkassignment.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksController {

    @GetMapping("/books")
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(generateBook());

        return books;
    }

    private Book generateBook() {
        Author author = Author.builder().id(1L).name("me").build();
        return Book.builder().id(1L).name("Test").description("Description").price(12.5).coverImage("CoverImage").author(author).build();
    }
}
