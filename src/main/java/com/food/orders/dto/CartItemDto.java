package com.food.orders.dto;


import com.food.orders.entities.Cart;

public class CartItemDto {
    private Integer id;
    private CartDto cart;
    private Integer quantity;
    private String productName;
    private Double price;

    public CartItemDto() {
    }

    public CartItemDto(Integer id,
                       CartDto cart,
                       Integer quantity,
                       String productName,
                       Double price) {
        this.id = id;
        this.cart = cart;
        this.quantity = quantity;
        this.productName = productName;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CartDto getCart() {
        return cart;
    }

    public void setCart(CartDto cart) {
        this.cart = cart;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CartItemDto{" +
                "id=" + id +
                ", cart=" + cart +
                ", quantity=" + quantity +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
