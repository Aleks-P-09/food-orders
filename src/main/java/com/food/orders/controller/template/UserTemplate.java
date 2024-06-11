package com.food.orders.controller.template;

import com.food.orders.entities.enums.UserRole;

public class UserTemplate {
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private UserRole role;

    public UserTemplate(String firstName,
                        String lastName,
                        String phone,
                        String address,
                        UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public UserTemplate() {
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

    @Override
    public String toString() {
        return "UserTemplate{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", role=" + role +
                '}';
    }
}
