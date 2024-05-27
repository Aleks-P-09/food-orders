package com.food.orders.dto;


import com.food.orders.entities.Favorites;
import com.food.orders.entities.enums.UserRole;

import java.time.LocalDateTime;
import java.util.List;

public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    private UserRole role;
    private LocalDateTime createdOn;
    private String createdBy;

    private List<FavoritesDto> favorites;

    public UserDto() {
    }

    public UserDto(Integer id,
                   String firstName,
                   String lastName,
                   String phone,
                   String address,
                   UserRole role,
                   LocalDateTime createdOn,
                   String createdBy,
                   List<FavoritesDto> favorites) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.favorites = favorites;
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

    public List<FavoritesDto> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<FavoritesDto> favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return "UserDto{" +
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
