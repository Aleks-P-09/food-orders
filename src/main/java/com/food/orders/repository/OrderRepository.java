package com.food.orders.repository;

import com.food.orders.entities.Order;
import com.food.orders.entities.OrderStatus;
import com.food.orders.entities.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByFirstName(String firstName);

    List<Order> findByLastStatus(Status lastStatus);
}
