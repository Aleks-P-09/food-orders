package com.food.orders.service;

import com.food.orders.controller.template.CartItemTemplate;
import com.food.orders.dto.CartItemDto;
import com.food.orders.dto.util.DtoUtil;
import com.food.orders.entities.Cart;
import com.food.orders.entities.CartItem;
import com.food.orders.entities.Product;
import com.food.orders.repository.CartItemRepository;
import com.food.orders.repository.CartRepository;
import com.food.orders.repository.ProductRepository;
import com.food.orders.service.interfaces.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {

    private CartItemRepository cartItemRepository;
    private CartRepository cartRepository;

    private ProductRepository productRepository;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository,
                               CartRepository cartRepository,
                               ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CartItemDto createCartItem(CartItemTemplate cartItemTemplate) {

        Optional<Cart> existingCart=cartRepository.findById(cartItemTemplate.getCartId());
        if (existingCart.isEmpty()){
            throw new RuntimeException("Cart with id "+cartItemTemplate.getCartId()+" does not exist.");
        }
        Cart cart=existingCart.get();

        Optional<Product> optionalProduct = productRepository.findById(cartItemTemplate.getProductId());
        if (optionalProduct.isEmpty()){
            throw new RuntimeException("Product with id "+cartItemTemplate.getProductId()+" does not exist.");
        }

        Product product=optionalProduct.get();

        CartItem cartItem=new CartItem();
        cartItem.setCart(cart);

        cartItem.setQuantity(cartItemTemplate.getQuantity());
        cartItem.setProductName(product.getName());
        cartItem.setPrice(product.getPrice());

        cartItemRepository.saveAndFlush(cartItem);
        return DtoUtil.toCartItemDto(cartItem);
    }

    @Override
    public CartItemDto updateCartItem(CartItemTemplate cartItemTemplate, Integer id) {
        Optional<CartItem> optionalCartItem=cartItemRepository.findById(id);
        if (optionalCartItem.isEmpty()){
            throw new RuntimeException("CartItem with id "+id+" is not found.");
        }

        CartItem cartItem=optionalCartItem.get();

        cartItem.setQuantity(cartItemTemplate.getQuantity());

        cartItemRepository.saveAndFlush(cartItem);
        return DtoUtil.toCartItemDto(cartItem);
    }

    @Override
    public void delete(Integer id) {
        Optional<CartItem> optionalCartItem = cartItemRepository.findById(id);
        if (optionalCartItem.isEmpty()){
            throw new RuntimeException("Cart item with id "+id+" is not found.");
        }
       cartItemRepository.deleteById(id);
    }
}
