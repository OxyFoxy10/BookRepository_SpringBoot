package org.example.bookrepospringbootmate.service;

import lombok.RequiredArgsConstructor;
import org.example.bookrepospringbootmate.dto.book.BookDto;
import org.example.bookrepospringbootmate.dto.book.CreateBookRequestDto;
import org.example.bookrepospringbootmate.exception.EntityNotFoundException;
import org.example.bookrepospringbootmate.mapper.BookMapper;
import org.example.bookrepospringbootmate.model.Book;
import org.example.bookrepospringbootmate.repository.BookRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        assert bookMapper != null;
        Book book = bookMapper.toModel(requestDto);
        assert bookRepository != null;
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }

    @Override
    public List<BookDto> findAll() {
        bookRepository.findById(1L).ifPresent(System.out::println);
//            bookRepository.findById(1L).ifPresent(p->System.out.println(p.hashCode()));
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto findById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDto)
                .orElseThrow(()-> new EntityNotFoundException("Book not found by id: " + id));
    }

    @Override
    public List<BookDto> findAllByTitle(String title) {
        //return employeeRepository.getAllByN(name).stream()
        return bookRepository.findAllByTitleContainingIgnoreCase(title).stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto update(CreateBookRequestDto requestDto) {
        assert bookMapper != null;
        Book book = bookMapper.toModel(requestDto);
        assert bookRepository != null;
        bookRepository.findById(book.getId()).orElseThrow(() ->
                new EntityNotFoundException("Not found book with id " + book.getId()
                        + " for update"));
        Book updatedBook = bookRepository.save(book);
        return bookMapper.toDto(updatedBook);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
