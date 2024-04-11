package com.jsmg.spring6demo.repositories;

import com.jsmg.spring6demo.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
