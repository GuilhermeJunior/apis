package com.simpleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simpleapi.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
