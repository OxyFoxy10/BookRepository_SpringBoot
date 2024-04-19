package org.example.bookrepospringbootmate.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.bookrepospringbootmate.dto.book.BookDto;
import org.example.bookrepospringbootmate.dto.book.CreateBookRequestDto;
import org.example.bookrepospringbootmate.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookDto> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDto findById(@PathVariable Long id) {
        //http://localhost:8080/employees/1
        return bookService.findById(id);
    }

    @GetMapping("/by-title")
    public List<BookDto> getAllByTitle(@RequestParam String title) {
        //http://localhost:8080/employees/by-name?name=John
        return bookService.findAllByTitle(title);
    }

    @PostMapping
    public BookDto save(@RequestBody CreateBookRequestDto requestDto) {
        return bookService.save(requestDto);
    }

    @PutMapping("/{id}")
    public BookDto update(@RequestBody CreateBookRequestDto requestDto, @PathVariable Long id) {
        return bookService.update(requestDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}
