package com.salandur.triforkassignment.repositories;

import com.salandur.triforkassignment.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Book, Long> {
}
