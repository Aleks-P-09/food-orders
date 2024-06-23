package com.food.orders.service;

import com.food.orders.dto.CartDto;
import com.food.orders.dto.util.DtoUtil;
import com.food.orders.entities.Cart;
import com.food.orders.repository.CartRepository;
import com.food.orders.service.interfaces.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public CartDto createCart() {
        Cart cart=new Cart();

        cart.setCreatedOn(LocalDateTime.now());

        cartRepository.saveAndFlush(cart);
        return DtoUtil.toCartDto(cart);
    }

    @Override
    public CartDto getCartById(Integer id) {
        Optional<Cart> optionalCart=cartRepository.findById(id);
        if (optionalCart.isEmpty()){
            throw new RuntimeException("Cart with id "+id+" is not found");
        }
        Cart cart=optionalCart.get();
        return DtoUtil.toCartDto(cart);
    }
}
