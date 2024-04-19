package org.example.bookrepospringbootmate.service;

import java.util.List;
import org.example.bookrepospringbootmate.dto.book.BookDto;
import org.example.bookrepospringbootmate.dto.book.CreateBookRequestDto;

public interface BookService {

    BookDto save(CreateBookRequestDto requestDto);

    List<BookDto> findAll();

    BookDto findById(Long id);

    List<BookDto> findAllByTitle(String title);

    BookDto update(CreateBookRequestDto requestDto);

    void delete(Long id);
}
