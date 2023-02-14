package com.salandur.triforkassignment.web;

import com.salandur.triforkassignment.domain.Book;
import com.salandur.triforkassignment.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BooksController {
    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/books")
    public Iterable<Book> getBooks(@RequestParam String title) {
        if (!ObjectUtils.isEmpty(title)) {
            return booksService.getBooksByTitle(title);
        }else {
            return booksService.getAllBooks();
        }
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book newBook) {
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
            book.setTitle(updateBook.getTitle());
            book.setDescription(updateBook.getDescription());
            book.setCoverImage(updateBook.getCoverImage());
            book.setPrice(updateBook.getPrice());

            return booksService.saveBook(book);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found"));
    }
}
