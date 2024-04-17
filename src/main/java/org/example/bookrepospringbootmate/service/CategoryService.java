package org.example.bookrepospringbootmate.service;

import org.example.bookrepospringbootmate.dto.category.CategoryDto;
import org.example.bookrepospringbootmate.dto.category.CreateCategoryRequestDto;

import java.util.List;

public interface CategoryService {
    public List<CategoryDto> findAll();
    public CategoryDto save(CreateCategoryRequestDto requestDto);
}
