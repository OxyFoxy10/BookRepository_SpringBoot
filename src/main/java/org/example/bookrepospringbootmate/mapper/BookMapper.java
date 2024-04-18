package org.example.bookrepospringbootmate.mapper;

import org.example.bookrepospringbootmate.config.MapperConfig;
import org.example.bookrepospringbootmate.dto.book.BookDto;
import org.example.bookrepospringbootmate.dto.book.CreateBookRequestDto;
import org.example.bookrepospringbootmate.model.Book;
import org.example.bookrepospringbootmate.model.Category;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Mapper(config= MapperConfig.class, uses = {CategoryMapper.class})
public interface BookMapper {

    @Mapping(target = "categoriesIds", ignore = true)
    BookDto toDto(Book book);

    @AfterMapping
    default  void setCategoriesIds(@MappingTarget BookDto bookDto, Book book) {
        if (book.getCategories() == null) {
            bookDto.setCategoriesIds(null);
        } else {
            List<Long> categoriesIds = book.getCategories().stream()
                    .map(Category::getId)
                    .toList();
            bookDto.setCategoriesIds(categoriesIds);
        }
    }

    @Mapping(target = "categories", ignore = true)
    Book toModel(CreateBookRequestDto requestDto);

    @AfterMapping
    default  void setCategories(@MappingTarget Book book, CreateBookRequestDto requestDto) {
        if (requestDto.categoriesIds() == null) {
            book.setCategories(null);
        } else{
            Set<Category> categories = requestDto.categoriesIds().stream()
                    .map(Category::new)
                    .collect(Collectors.toSet());
            book.setCategories(categories);
        }
    }
}
