package com.food.orders.dto;


import com.food.orders.entities.enums.Status;

import java.time.LocalDateTime;

public class OrderStatusDto {
    private Integer id;
    private LocalDateTime createdOn;
    private String createdBy;
    private Status status;
    private String notes;

    public OrderStatusDto() {
    }

    public OrderStatusDto(Integer id,
                          LocalDateTime createdOn,
                          String createdBy,
                          Status status,
                          String notes) {
        this.id = id;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.status = status;
        this.notes = notes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "OrderStatusDto{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", createdBy='" + createdBy + '\'' +
                ", status=" + status +
                ", notes='" + notes + '\'' +
                '}';
    }
}
