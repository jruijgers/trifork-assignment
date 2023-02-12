package com.salandur.triforkassignment.service;

import com.salandur.triforkassignment.domain.Author;
import com.salandur.triforkassignment.domain.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(generateBook());

        return books;
    }

    private Book generateBook() {
        Author author = Author.builder().id(1L).name("me").build();
        return Book.builder().id(1L).name("Test").description("Description").price(12.5).coverImage("CoverImage").author(author).build();
    }
}
