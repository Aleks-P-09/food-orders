package com.food.orders.controller;

import com.food.orders.controller.template.CartTemplate;
import com.food.orders.controller.template.UserTemplate;
import com.food.orders.dto.CartDto;
import com.food.orders.dto.UserDto;
import com.food.orders.service.interfaces.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<CartDto> createCart(){
        return ResponseEntity.ok(this.cartService.createCart());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable ("id") Integer id) {
        return ResponseEntity.ok(cartService.getCartById(id));
    }
}
