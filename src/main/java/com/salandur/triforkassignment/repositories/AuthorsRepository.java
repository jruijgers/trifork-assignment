package com.salandur.triforkassignment.repositories;

import com.salandur.triforkassignment.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorsRepository extends CrudRepository<Author, Long> {
}
