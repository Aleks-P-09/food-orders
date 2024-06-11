package com.food.orders.controller.template;

public class UpdateProductTemplate {
    private String name;
    private Double price;
    private boolean available;
    private String description;
    private String imageUrl;
    private Integer categoryId;  //Category category

    public UpdateProductTemplate() {
    }

    public UpdateProductTemplate(String name,
                                 Double price,
                                 boolean available,
                                 String description,
                                 String imageUrl,
                                 Integer categoryId) {
        this.name = name;
        this.price = price;
        this.available = available;
        this.description = description;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "UpdateProductTemplate{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
