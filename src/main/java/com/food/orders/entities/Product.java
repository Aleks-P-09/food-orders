package com.food.orders.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "available", nullable = false)
    private boolean available;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User createdBy;
    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;



    public Product(Integer id,
                   String name,
                   Double price,
                   boolean available,
                   String description,
                   String imageUrl,
                   User createdBy,
                   LocalDateTime createdOn) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.available = available;
        this.description = description;
        this.imageUrl = imageUrl;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
    }

    public Product() {
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

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
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
