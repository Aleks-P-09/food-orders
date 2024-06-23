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

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order order;
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
                       Order order,
                       LocalDateTime createdOn,
                       String createdBy,
                       Status status,
                       String notes) {
        this.id = id;
        this.order = order;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "id=" + id +
                ", order=" + order +
                ", createdOn=" + createdOn +
                ", createdBy='" + createdBy + '\'' +
                ", status=" + status +
                ", notes='" + notes + '\'' +
                '}';
    }
}
