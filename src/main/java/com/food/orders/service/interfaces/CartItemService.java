package com.food.orders.service.interfaces;

import com.food.orders.controller.template.CartItemTemplate;
import com.food.orders.dto.CartItemDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartItemService {
    CartItemDto createCartItem(CartItemTemplate cartItemTemplate);

    CartItemDto updateCartItem(CartItemTemplate cartItemTemplate, Integer id);

    void delete(Integer id);
}
