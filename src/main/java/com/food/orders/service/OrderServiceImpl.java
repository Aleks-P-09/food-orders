package com.food.orders.service;

import com.food.orders.controller.template.OrderTemplate;
import com.food.orders.dto.OrderDto;
import com.food.orders.dto.util.DtoUtil;
import com.food.orders.entities.Cart;
import com.food.orders.entities.Order;
import com.food.orders.entities.OrderStatus;
import com.food.orders.entities.enums.Status;
import com.food.orders.repository.CartRepository;
import com.food.orders.repository.OrderRepository;
import com.food.orders.repository.OrderStatusRepository;
import com.food.orders.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private CartRepository cartRepository;

    private OrderStatusRepository orderStatusRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            CartRepository cartRepository,
                            OrderStatusRepository orderStatusRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.orderStatusRepository = orderStatusRepository;
    }

    @Override
    public OrderDto createOrder(OrderTemplate orderTemplate) {

        Optional<Cart> existingCart = cartRepository.findById(orderTemplate.getCartId());
        if (existingCart.isEmpty()){
            throw new RuntimeException("Cart with id "+ orderTemplate.getCartId()+" already exist");
        }

        Cart cart=existingCart.get();

        Order order=new Order();

        order.setFirstName(orderTemplate.getFirstName());
        order.setLastName(orderTemplate.getLastName());
        order.setAddress(orderTemplate.getAddress());
        order.setPhone(orderTemplate.getPhone());
        order.setLastStatus(Status.PLACED);
        order.setCart(cart);

        OrderStatus orderStatus=new OrderStatus();

        orderStatus.setStatus(Status.PLACED);
        orderStatus.setCreatedBy(orderTemplate.getFirstName()+" "+ orderTemplate.getLastName());
        orderStatus.setCreatedOn(LocalDateTime.now());
        orderStatus.setNotes(orderTemplate.getNotes());

        order.getOrderStatuses().add(orderStatus);
        orderStatus.setOrder(order);

        orderRepository.saveAndFlush(order);
        orderStatusRepository.saveAndFlush(orderStatus);

        return DtoUtil.toOrderDto(order);
    }

    @Override
    public OrderDto updateOrder(OrderTemplate orderTemplate, Integer id) {
        Optional<Order> optionalOrder=orderRepository.findById(id);
        if (optionalOrder.isEmpty()){
            throw new RuntimeException("Order for "+ orderTemplate.getFirstName()+" is not found");
        }

        Order order=optionalOrder.get();

        order.setFirstName(orderTemplate.getFirstName());
        order.setLastName(orderTemplate.getLastName());
        order.setAddress(orderTemplate.getAddress());
        order.setPhone(orderTemplate.getPhone());

        orderRepository.saveAndFlush(order);
        return DtoUtil.toOrderDto(order);
    }

    @Override
    public OrderDto getOrderById(Integer id) {
        Optional<Order> existingOrder = orderRepository.findById(id);
        if (existingOrder.isEmpty()){
            throw new RuntimeException("Order with id "+id+" is not found.");
        }
        Order order=existingOrder.get();
        return DtoUtil.toOrderDto(order);
    }

    @Override
    public List<OrderDto> getOrderByStatus(Status status) {
        return orderRepository.findByLastStatus(status)
                .stream()
                .map(order -> DtoUtil.toOrderDto(order))
                .collect(Collectors.toList());
    }
}
