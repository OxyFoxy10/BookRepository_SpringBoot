package org.example.bookrepospringbootmate.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookrepospringbootmate.model.Cart;
import org.example.bookrepospringbootmate.service.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    @GetMapping("/{id}")
    public Cart findById(@PathVariable Long id) {
        //http://localhost:8080/employees/1
        return cartService.findById(id);
    }

    @PostMapping
    public Cart save(@RequestBody Cart cart) {
        return cartService.save(cart);
    }

    @PutMapping("/{id}")
    public Cart update(@RequestBody Cart cart, @PathVariable Long id) {
        return cartService.update(cart);
    }
}
