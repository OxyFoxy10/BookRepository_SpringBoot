package org.example.bookrepospringbootmate.repository;

import org.example.bookrepospringbootmate.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepository extends JpaRepository<CartItem, Long> {
}
