package org.example.bookrepospringbootmate.repository;

import org.example.bookrepospringbootmate.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
