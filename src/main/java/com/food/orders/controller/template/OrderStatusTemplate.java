package com.food.orders.controller.template;

import com.food.orders.entities.enums.Status;

public class OrderStatusTemplate {

    private Integer orderId;
    private String createdBy;
    private Status status;
    private String notes;

    public OrderStatusTemplate() {
    }

    public OrderStatusTemplate(Integer orderId, String createdBy,
                               Status status,
                               String notes) {
        this.orderId = orderId;

        this.createdBy = createdBy;
        this.status = status;
        this.notes = notes;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderStatusTemplate{" +
                "orderId=" + orderId +
                ", createdBy='" + createdBy + '\'' +
                ", status=" + status +
                ", notes='" + notes + '\'' +
                '}';
    }
}
