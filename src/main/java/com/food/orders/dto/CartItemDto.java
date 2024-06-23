package com.food.orders.dto;


import com.food.orders.entities.Cart;

public class CartItemDto {
    private Integer id;

    private Integer quantity;
    private String productName;
    private Double price;

    public CartItemDto() {
    }

    public CartItemDto(Integer id,
                       Integer quantity,
                       String productName,
                       Double price) {
        this.id = id;
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
                ", quantity=" + quantity +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
