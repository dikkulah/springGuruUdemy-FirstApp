package com.dikkulah.springapp.repositories;

import com.dikkulah.springapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
