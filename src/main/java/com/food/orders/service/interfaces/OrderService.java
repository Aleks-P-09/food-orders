package com.food.orders.service.interfaces;

import com.food.orders.controller.template.OrderTemplate;
import com.food.orders.dto.OrderDto;
import com.food.orders.entities.enums.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    OrderDto createOrder(OrderTemplate orderTemplate);


    OrderDto updateOrder(OrderTemplate orderTemplate, Integer id);


    OrderDto getOrderById(Integer id);

    List<OrderDto> getOrderByStatus(Status status);
}
