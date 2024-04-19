package org.example.bookrepospringbootmate.service;

import lombok.RequiredArgsConstructor;
import org.example.bookrepospringbootmate.model.CartItem;
import org.example.bookrepospringbootmate.repository.CartItemsRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartItemsServiceImpl implements CartItemsService {

    private final CartItemsRepository cartItemsRepository;

    @Override
    public CartItem save(CartItem cartItem) {
        return cartItemsRepository.save(cartItem);
    }

    @Override
    public CartItem findById(Long id) {
        return cartItemsRepository.findById(id).orElse(null);
    }

    @Override
    public CartItem update(CartItem cartItem) {
        if (cartItemsRepository.existsById(cartItem.getId())) {
            return cartItemsRepository.save(cartItem);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        cartItemsRepository.deleteById(id);
    }
}
