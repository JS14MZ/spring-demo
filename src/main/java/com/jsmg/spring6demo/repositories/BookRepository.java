package com.jsmg.spring6demo.repositories;

import com.jsmg.spring6demo.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
