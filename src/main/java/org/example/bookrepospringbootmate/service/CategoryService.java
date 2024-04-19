package org.example.bookrepospringbootmate.service;

import java.util.List;
import org.example.bookrepospringbootmate.dto.category.CategoryDto;
import org.example.bookrepospringbootmate.dto.category.CreateCategoryRequestDto;

public interface CategoryService {

    List<CategoryDto> findAll();

    CategoryDto save(CreateCategoryRequestDto requestDto);
}
