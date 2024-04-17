package org.example.bookrepospringbootmate.dto.book;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
    public class BookDto {
        private Long id;
        private String title;
        private String author;
        private BigDecimal price;
        private String isbn;
    private List<Long> categoriesIds;

}

