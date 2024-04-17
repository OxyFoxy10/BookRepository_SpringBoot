package org.example.bookrepospringbootmate.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookrepospringbootmate.dto.book.BookDto;
import org.example.bookrepospringbootmate.dto.book.CreateBookRequestDto;
import org.example.bookrepospringbootmate.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
public BookDto updateById(@RequestBody CreateBookRequestDto requestDto, @PathVariable Long id) {
    return bookService.update(requestDto);
}
@ResponseStatus(HttpStatus.NO_CONTENT)
@DeleteMapping("/{id}")
public void delete(@PathVariable Long id) {
    bookService.delete(id);
}

}
