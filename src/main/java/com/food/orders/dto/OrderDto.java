package com.food.orders.dto;



import com.food.orders.entities.Cart;
import com.food.orders.entities.OrderStatus;

import java.util.List;

public class OrderDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private List<OrderStatusDto> orderStatuses;
    private CartDto cart;

    public OrderDto() {
    }

    public OrderDto(Integer id,
                    String firstName,
                    String lastName,
                    String phone,
                    String address,
                    List<OrderStatusDto> orderStatuses,
                    CartDto cart) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.orderStatuses = orderStatuses;
        this.cart = cart;
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

    public List<OrderStatusDto> getOrderStatuses() {
        return orderStatuses;
    }

    public void setOrderStatuses(List<OrderStatusDto> orderStatuses) {
        this.orderStatuses = orderStatuses;
    }

    public CartDto getCart() {
        return cart;
    }

    public void setCart(CartDto cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", orderStatuses=" + orderStatuses +
                ", cart=" + cart +
                '}';
    }
}
