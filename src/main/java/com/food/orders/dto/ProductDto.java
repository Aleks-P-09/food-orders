package com.food.orders.dto;

import com.food.orders.entities.Category;
import com.food.orders.entities.User;

import java.time.LocalDateTime;

public class ProductDto {
    private Integer id;
    private String name;
    private Double price;
    private boolean available;
    private String description;
    private String imageUrl;
    private UserDto createdBy;
    private LocalDateTime createdOn;
    private CategoryDto category;


    public ProductDto() {
    }

    public ProductDto(Integer id,
                      String name,
                      Double price,
                      boolean available,
                      String description,
                      String imageUrl,
                      UserDto createdBy,
                      LocalDateTime createdOn,
                      CategoryDto category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.available = available;
        this.description = description;
        this.imageUrl = imageUrl;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public UserDto getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserDto createdBy) {
        this.createdBy = createdBy;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                ", category=" + category +
                '}';
    }
}
