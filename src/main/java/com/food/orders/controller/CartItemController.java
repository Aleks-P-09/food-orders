package com.food.orders.controller;

import com.food.orders.controller.template.CartItemTemplate;
import com.food.orders.controller.template.UpdateProductTemplate;
import com.food.orders.controller.template.UserTemplate;
import com.food.orders.dto.CartItemDto;
import com.food.orders.dto.ProductDto;
import com.food.orders.dto.UserDto;
import com.food.orders.entities.CartItem;
import com.food.orders.service.interfaces.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart-item")
public class CartItemController {
    private CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping
    public ResponseEntity<CartItemDto> createCartItem(@RequestBody CartItemTemplate cartItemTemplate) {
        return ResponseEntity.ok(this.cartItemService.createCartItem(cartItemTemplate));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItemDto> updateCartItem(@RequestBody CartItemTemplate cartItemTemplate, @PathVariable("id")Integer id){
        return ResponseEntity.ok(this.cartItemService.updateCartItem(cartItemTemplate, id));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")Integer id){
        cartItemService.delete(id);
    }

}
