package com.simplebookstore.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplebookstore.api.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
