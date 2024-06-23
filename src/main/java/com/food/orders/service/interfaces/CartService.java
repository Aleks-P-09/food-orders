package com.food.orders.service.interfaces;

import com.food.orders.controller.template.CartTemplate;
import com.food.orders.dto.CartDto;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    CartDto createCart();

    CartDto getCartById(Integer id);
}
