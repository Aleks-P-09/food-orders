package com.food.orders.controller.template;

import com.food.orders.entities.Cart;

public class CartItemTemplate {
    private Integer cartId;

    private Integer productId;
    private Integer quantity;


    public CartItemTemplate() {
    }

    public CartItemTemplate(Integer cartId, Integer productId, Integer quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItemTemplate{" +
                "cartId=" + cartId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
