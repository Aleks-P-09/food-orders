package com.food.orders.controller;

import com.food.orders.controller.template.OrderTemplate;
import com.food.orders.dto.OrderDto;
import com.food.orders.entities.enums.Status;
import com.food.orders.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("orderId") Integer id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<OrderDto>> getOrderByStatus(@PathVariable("status") Status status) {
        return ResponseEntity.ok(orderService.getOrderByStatus(status));
    }
    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderTemplate orderTemplate){
        return ResponseEntity.ok(this.orderService.createOrder(orderTemplate));
    }


    @PutMapping("/{orderId}")
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderTemplate orderTemplate, @PathVariable("orderId")Integer id){
        return ResponseEntity.ok(this.orderService.updateOrder(orderTemplate, id));
    }
}

