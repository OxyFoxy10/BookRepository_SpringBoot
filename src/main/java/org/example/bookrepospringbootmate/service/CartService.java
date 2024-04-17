package org.example.bookrepospringbootmate.service;

import org.example.bookrepospringbootmate.model.Cart;


public interface CartService {

    Cart save(Cart cart);
    Cart findById(Long id);
    Cart update(Cart cart);
    void deleteById(Long id);
}
