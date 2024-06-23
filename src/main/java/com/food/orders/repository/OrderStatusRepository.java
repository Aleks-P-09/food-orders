package com.food.orders.repository;

import com.food.orders.entities.OrderStatus;
import com.food.orders.entities.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
    Optional<OrderStatus> findOrderStatusByStatus(Status status);
}
