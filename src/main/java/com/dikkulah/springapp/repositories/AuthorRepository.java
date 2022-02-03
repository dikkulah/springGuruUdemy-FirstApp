package com.dikkulah.springapp.repositories;

import com.dikkulah.springapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
