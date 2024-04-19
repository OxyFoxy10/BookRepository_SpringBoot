package org.example.bookrepospringbootmate.dto.book;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private BigDecimal price;
    private String isbn;
    private List<Long> categoriesIds;
}
