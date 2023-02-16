package com.salandur.triforkassignment.web;

import com.salandur.triforkassignment.domain.Author;
import com.salandur.triforkassignment.domain.Book;
import com.salandur.triforkassignment.service.AuthorsService;
import com.salandur.triforkassignment.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class BooksController {
    private final BooksService booksService;
    private final AuthorsService authorsService;

    @Autowired
    public BooksController(BooksService booksService, AuthorsService authorsService) {
        this.booksService = booksService;
        this.authorsService = authorsService;
    }

    @GetMapping("/books")
    public Iterable<Book> getBooks(@RequestParam(required = false) String title, @RequestParam(required = false) Long authorId) {
        if (!ObjectUtils.isEmpty(title)) {
            return booksService.getBooksByTitle(title);
        } else if (!ObjectUtils.isEmpty(authorId)) {
            Author author = authorsService.getAuthorById(authorId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));
            return booksService.getBooksByAuthor(author);
        } else {
            return booksService.getAllBooks();
        }

    }

    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book newBook) {
        return booksService.createBook(newBook);
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) {
        return booksService.getBookById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found"));
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book updateBook, @PathVariable Long id) {
        return booksService.getBookById(id).map(book -> {
            if (!ObjectUtils.isEmpty(updateBook.getTitle())) {
                book.setTitle(updateBook.getTitle());
            }
            if (!ObjectUtils.isEmpty(updateBook.getDescription())) {
                book.setDescription(updateBook.getDescription());
            }
            if (!ObjectUtils.isEmpty(updateBook.getCoverImage())) {
                book.setCoverImage(updateBook.getCoverImage());
            }
            if (!ObjectUtils.isEmpty(updateBook.getPrice())) {
                book.setPrice(updateBook.getPrice());
            }

            if (!ObjectUtils.isEmpty(updateBook.getAuthor())) {
                authorsService.getAuthorById(updateBook.getAuthor().getId()).
                        ifPresent(author -> book.setAuthor(author));
            }

            return booksService.saveBook(book);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found"));
    }
}
