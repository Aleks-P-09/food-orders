package com.food.orders.service;

import com.food.orders.controller.template.OrderStatusTemplate;
import com.food.orders.dto.OrderStatusDto;
import com.food.orders.dto.util.DtoUtil;
import com.food.orders.entities.Order;
import com.food.orders.entities.OrderStatus;
import com.food.orders.repository.OrderRepository;
import com.food.orders.repository.OrderStatusRepository;
import com.food.orders.service.interfaces.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    private OrderStatusRepository orderStatusRepository;
    private OrderRepository orderRepository;

    @Autowired
    public OrderStatusServiceImpl(OrderStatusRepository orderStatusRepository,
                                  OrderRepository orderRepository) {
        this.orderStatusRepository = orderStatusRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderStatusDto createOrderStatus(OrderStatusTemplate orderStatusTemplate) {
        Optional<Order> optionalOrder=orderRepository.findById(orderStatusTemplate.getOrderId());
        if (optionalOrder.isEmpty()){
            throw new RuntimeException("Order id "+orderStatusTemplate.getOrderId()+" is not found.");
        }

        Order order=optionalOrder.get();

        OrderStatus orderStatus=new OrderStatus();

        orderStatus.setCreatedOn(LocalDateTime.now());
        orderStatus.setCreatedBy(orderStatusTemplate.getCreatedBy());
        orderStatus.setStatus(orderStatusTemplate.getStatus());
        orderStatus.setNotes(orderStatusTemplate.getNotes());
        orderStatus.setOrder(order);

        order.setLastStatus(orderStatusTemplate.getStatus());

        orderRepository.saveAndFlush(order);
        orderStatusRepository.saveAndFlush(orderStatus);
        return DtoUtil.toOrderStatusDto(orderStatus);
    }

    @Override
    public OrderStatusDto updateOrderStatus(OrderStatusTemplate orderStatusTemplate, Integer id) {
        Optional<OrderStatus> optionalOrderStatus=orderStatusRepository.findById(id);
        if (optionalOrderStatus.isEmpty()){
            throw new RuntimeException("Order status "+orderStatusTemplate.getStatus()+" is not found.");
        }

        OrderStatus orderStatus=optionalOrderStatus.get();

        orderStatus.setCreatedBy(orderStatusTemplate.getCreatedBy());

        orderStatus.setNotes(orderStatusTemplate.getNotes());

        orderStatusRepository.saveAndFlush(orderStatus);
        return DtoUtil.toOrderStatusDto(orderStatus);
    }


}
