package com.salandur.triforkassignment;

import com.salandur.triforkassignment.domain.Book;
import com.salandur.triforkassignment.web.BooksController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TriforkAssignmentApplicationTests {

    @Autowired
    private BooksController booksController;

    @Test
    void contextLoads() {
        assertThat(booksController).isNotNull();
    }

    @Test
    void getBooksShouldReturnAllBooks() {
        Iterable<Book> books = booksController.getBooks(null, null);

        int bookCount = 0;
        for (Book book : books) {
            bookCount++;
        }

        assertThat(bookCount).isEqualTo(2);
    }

}
