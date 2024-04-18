package org.example.bookrepospringbootmate.mapper;

import org.example.bookrepospringbootmate.config.MapperConfig;
import org.example.bookrepospringbootmate.dto.category.CategoryDto;
import org.example.bookrepospringbootmate.dto.category.CreateCategoryRequestDto;
import org.example.bookrepospringbootmate.model.Category;
import org.mapstruct.Mapper;

@Mapper(config= MapperConfig.class)
public interface CategoryMapper {

    CategoryDto toDto(Category category);

    Category toEntity(CreateCategoryRequestDto requestDto);
}
