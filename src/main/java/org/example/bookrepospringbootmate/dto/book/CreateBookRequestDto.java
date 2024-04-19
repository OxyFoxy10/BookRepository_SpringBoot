package org.example.bookrepospringbootmate.dto.book;

import java.math.BigDecimal;
import java.util.List;

public record CreateBookRequestDto(String title,
                                   String author,
                                   String isbn,
                                   BigDecimal price,
                                   String description,
                                   String coverImage,
                                   List<Long> categoriesIds) {
}
