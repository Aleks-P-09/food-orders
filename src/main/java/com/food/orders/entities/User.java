package com.food.orders.entities;

import com.food.orders.entities.enums.UserRole;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "role", nullable = false)
    private UserRole role;
    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;
    @Column(name ="created_by", nullable = false )
    private String createdBy;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Favorites> favorites;

    public User() {
        this.favorites=new ArrayList<>();
    }

    public User(Integer id,
                String firstName,
                String lastName,
                String phone,
                String address,
                UserRole role,
                LocalDateTime createdOn,
                String createdBy) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<Favorites> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorites> favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", role=" + role +
                ", createdOn=" + createdOn +
                ", createdBy='" + createdBy + '\'' +
                ", favorites=" + favorites +
                '}';
    }
}
