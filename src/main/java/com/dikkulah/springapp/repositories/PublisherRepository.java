package com.dikkulah.springapp.repositories;

import com.dikkulah.springapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
