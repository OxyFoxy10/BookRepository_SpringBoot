package org.example.bookrepospringbootmate.service;

import org.example.bookrepospringbootmate.model.CartItem;

public interface CartItemsService {

    CartItem save(CartItem cartItem);

    CartItem findById(Long id);

    CartItem update(CartItem cartItem);

    void delete(Long id);
}
