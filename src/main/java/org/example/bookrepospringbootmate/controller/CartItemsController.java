package org.example.bookrepospringbootmate.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookrepospringbootmate.model.CartItem;
import org.example.bookrepospringbootmate.service.CartItemsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cartitems")
public class CartItemsController {

    private final CartItemsService cartItemsService;

    @PostMapping
    public ResponseEntity<CartItem> save(@RequestBody CartItem cartItem) {
        CartItem savedCartItem = cartItemsService.save(cartItem);
        return new ResponseEntity<>(savedCartItem, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public CartItem findById(@PathVariable Long id) {
        return cartItemsService.findById(id);
    }

    @PutMapping("/{id}")
    public CartItem update(@RequestBody CartItem cartItem, @PathVariable Long id) {
        return cartItemsService.update(cartItem);
    }
}
