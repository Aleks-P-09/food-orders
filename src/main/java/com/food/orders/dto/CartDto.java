package com.food.orders.dto;


import com.food.orders.entities.CartItem;

import java.time.LocalDateTime;
import java.util.List;

public class CartDto {
    private Integer id;

    private LocalDateTime createdOn;

    private List<CartItemDto> cartItems;

    public CartDto() {
    }

    public CartDto(Integer id,
                   LocalDateTime createdOn,
                   List<CartItemDto> cartItems) {
        this.id = id;
        this.createdOn = createdOn;
        this.cartItems = cartItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "CartDto{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", cartItems=" + cartItems +
                '}';
    }
}
