package org.example.bookrepospringbootmate.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.bookrepospringbootmate.dto.category.CategoryDto;
import org.example.bookrepospringbootmate.dto.category.CreateCategoryRequestDto;
import org.example.bookrepospringbootmate.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @PostMapping
    public CategoryDto save(@RequestBody CreateCategoryRequestDto requestDto) {
        return categoryService.save(requestDto);
    }
}
