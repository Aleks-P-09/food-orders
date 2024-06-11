package com.food.orders.controller.template;

import com.food.orders.dto.CategoryDto;
import com.food.orders.dto.UserDto;

public class CreateProductTemplate {
    private String name;
    private Double price;
    private boolean available;
    private String description;
    private String imageUrl;
    private Integer userId;     // User createdBy
    private Integer categoryId;  //Category category

    public CreateProductTemplate(String name,
                                 Double price,
                                 boolean available,
                                 String description,
                                 String imageUrl,
                                 Integer userId,
                                 Integer categoryId) {
        this.name = name;
        this.price = price;
        this.available = available;
        this.description = description;
        this.imageUrl = imageUrl;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public CreateProductTemplate() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "CreateProductTemplate{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", userId=" + userId +
                ", categoryId=" + categoryId +
                '}';
    }
}
