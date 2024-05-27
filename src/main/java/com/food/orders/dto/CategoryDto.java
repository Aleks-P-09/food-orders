package com.food.orders.dto;


import com.food.orders.entities.Product;

import java.util.List;

public class CategoryDto {
    private Integer id;
    private String name;
    private List<ProductDto> products;

    public CategoryDto() {
    }

    public CategoryDto(Integer id,
                       String name,
                       List<ProductDto> products) {
        this.id = id;
        this.name = name;
        this.products = products;
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

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
