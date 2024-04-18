package org.example.bookrepospringbootmate.repository;

import org.example.bookrepospringbootmate.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitleContainingIgnoreCase(String title);
}
