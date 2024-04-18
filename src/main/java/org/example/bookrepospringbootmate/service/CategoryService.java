package org.example.bookrepospringbootmate.service;

import org.example.bookrepospringbootmate.dto.category.CategoryDto;
import org.example.bookrepospringbootmate.dto.category.CreateCategoryRequestDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();

    CategoryDto save(CreateCategoryRequestDto requestDto);
}
