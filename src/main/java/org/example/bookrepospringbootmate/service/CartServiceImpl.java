package org.example.bookrepospringbootmate.service;

import lombok.RequiredArgsConstructor;
import org.example.bookrepospringbootmate.model.Cart;
import org.example.bookrepospringbootmate.repository.CartRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart findById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public Cart update(Cart cart) {
        if(cartRepository.existsById(cart.getId())) {
            return cartRepository.save(cart);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
    cartRepository.deleteById(id);
    }
}
