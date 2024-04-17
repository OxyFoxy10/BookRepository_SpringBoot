package org.example.bookrepospringbootmate.repository;

import org.example.bookrepospringbootmate.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
