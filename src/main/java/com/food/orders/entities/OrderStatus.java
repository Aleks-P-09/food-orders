package com.food.orders.entities;

import com.food.orders.entities.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_status")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;
    @Column(name ="created_by", nullable = false )
    private String createdBy;
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "notes")
    private String notes;

    public OrderStatus() {
    }

    public OrderStatus(Integer id,
                       LocalDateTime createdOn,
                       String createdBy,
                       Status status) {
        this.id = id;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.status = status;
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
        return "OrderStatus{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", createdBy='" + createdBy + '\'' +
                ", status=" + status +
                ", notes='" + notes + '\'' +
                '}';
    }
}
