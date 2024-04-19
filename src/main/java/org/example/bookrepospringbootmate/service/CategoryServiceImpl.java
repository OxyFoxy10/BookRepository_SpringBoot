package org.example.bookrepospringbootmate.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.bookrepospringbootmate.dto.category.CategoryDto;
import org.example.bookrepospringbootmate.dto.category.CreateCategoryRequestDto;
import org.example.bookrepospringbootmate.mapper.CategoryMapper;
import org.example.bookrepospringbootmate.model.Category;
import org.example.bookrepospringbootmate.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
            .map(categoryMapper::toDto)
            .collect(Collectors.toList());
    }

    @Override
    public CategoryDto save(CreateCategoryRequestDto requestDto) {
        Category entity = categoryMapper.toEntity(requestDto);
        return categoryMapper.toDto(categoryRepository.save(entity));
    }
}
