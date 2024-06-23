package com.food.orders.controller;

import com.food.orders.controller.template.CreateProductTemplate;
import com.food.orders.controller.template.OrderStatusTemplate;
import com.food.orders.controller.template.UpdateProductTemplate;
import com.food.orders.dto.OrderStatusDto;
import com.food.orders.dto.ProductDto;
import com.food.orders.entities.enums.Status;
import com.food.orders.service.interfaces.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-status")
public class OrderStatusController {

    private OrderStatusService orderStatusService;

    @Autowired
    public OrderStatusController(OrderStatusService orderStatusService) {
        this.orderStatusService = orderStatusService;
    }

    @PostMapping
    public ResponseEntity<OrderStatusDto> createOrderStatus(@RequestBody OrderStatusTemplate orderStatusTemplate){
        return ResponseEntity.ok(this.orderStatusService.createOrderStatus(orderStatusTemplate));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderStatusDto> updateOrderStatus(@RequestBody OrderStatusTemplate orderStatusTemplate, @PathVariable("id") Integer id){
        return ResponseEntity.ok(this.orderStatusService.updateOrderStatus(orderStatusTemplate, id));
    }

}
