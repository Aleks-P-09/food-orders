package com.food.orders.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "favorites")
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public Favorites() {
    }

    public Favorites(Integer id,
                     Product product,
                     User user) {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "id=" + id +
                ", product=" + product +
                ", user=" + user +
                '}';
    }
}
