package com.food.orders.controller.template;

import com.food.orders.dto.CartItemDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CartTemplate {
    private LocalDateTime createdOn;

    private List<CartItemDto> cartItems;

    public CartTemplate() {

    }

    public CartTemplate(LocalDateTime createdOn, List<CartItemDto> cartItems) {
        this.createdOn = createdOn;
        this.cartItems = cartItems;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "CartTemplate{" +
                "createdOn=" + createdOn +
                ", cartItems=" + cartItems +
                '}';
    }
}
