package org.example.bookrepospringbootmate.repository;

import org.example.bookrepospringbootmate.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
