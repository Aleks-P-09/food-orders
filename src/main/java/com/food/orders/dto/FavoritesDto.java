package com.food.orders.dto;


import com.food.orders.entities.Product;
import com.food.orders.entities.User;

public class FavoritesDto {
    private Integer id;
    private ProductDto product;
    private UserDto user;

    public FavoritesDto() {
    }

    public FavoritesDto(Integer id,
                        ProductDto product,
                        UserDto user) {
        this.id = id;
        this.product = product;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "FavoritesDto{" +
                "id=" + id +
                ", product=" + product +
                ", user=" + user +
                '}';
    }
}
