package com.food.orders.controller.template;

public class OrderTemplate {
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private Integer cartId;

    private String notes;

    public OrderTemplate() {
    }

    public OrderTemplate(String firstName,
                         String lastName,
                         String phone,
                         String address,
                         Integer cartId,
                         String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.cartId = cartId;
        this.notes = notes;
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

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "CustomerOrderTemplate{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", cartId=" + cartId +
                ", notes='" + notes + '\'' +
                '}';
    }
}
