package com.food.orders.controller.template;

import com.food.orders.dto.ProductDto;
import com.food.orders.dto.UserDto;
import com.food.orders.entities.Product;
import com.food.orders.entities.User;

public class FavoritesTemplate {
    private Integer productId;
    private Integer userId;

    public FavoritesTemplate() {
    }

    public FavoritesTemplate(Integer productId, Integer userId) {
        this.productId = productId;
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FavoritesTemplate{" +
                "productId=" + productId +
                ", userId=" + userId +
                '}';
    }
}
