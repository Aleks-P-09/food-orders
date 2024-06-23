package com.food.orders.service.interfaces;

import com.food.orders.controller.template.OrderStatusTemplate;
import com.food.orders.dto.OrderStatusDto;
import com.food.orders.entities.enums.Status;
import org.springframework.stereotype.Service;

@Service
public interface OrderStatusService {
    OrderStatusDto createOrderStatus(OrderStatusTemplate orderStatusTemplate);

    OrderStatusDto updateOrderStatus(OrderStatusTemplate orderStatusTemplate, Integer id);

}
