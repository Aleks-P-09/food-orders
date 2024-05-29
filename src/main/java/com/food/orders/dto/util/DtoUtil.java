package com.food.orders.dto.util;

import com.food.orders.dto.*;
import com.food.orders.entities.*;

import java.util.List;
import java.util.stream.Collectors;


public class DtoUtil {

    public static ProductDto toProductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.isAvailable(),
                product.getDescription(),
                product.getImageUrl(),
                DtoUtil.toUserDto(product.getCreatedBy()),
                product.getCreatedOn(),
                DtoUtil.toCategoryDto(product.getCategory())
        );
    }

    public static UserDto toUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getAddress(),
                user.getRole(),
                user.getCreatedOn(),
                user.getCreatedBy(),
                user.getFavorites().stream().map(favorites -> toFavoritesDto(favorites)).collect(Collectors.toList())
//                user.getFavorites().stream().map(favorites -> toFavoritesDto(favorites)).toList()
        );
    }

    public static OrderStatusDto toOrderStatusDto (OrderStatus orderStatus){
        return new OrderStatusDto(
                orderStatus.getId(),
                orderStatus.getCreatedOn(),
                orderStatus.getCreatedBy(),
                orderStatus.getStatus(),
                orderStatus.getNotes()
        );
    }

    public static OrderDto toOrderDto(Order order){
        return new OrderDto(
                order.getId(),
                order.getFirstName(),
                order.getLastName(),
                order.getPhone(),
                order.getAddress(),
                order.getOrderStatuses().stream().map(orderStatus -> toOrderStatusDto(orderStatus)).collect(Collectors.toList()),
                DtoUtil.toCartDto(order.getCart())
        );
    }

    public static FavoritesDto toFavoritesDto(Favorites favorites){
        return new FavoritesDto(
                favorites.getId(),
                DtoUtil.toProductDto(favorites.getProduct()),
                DtoUtil.toUserDto(favorites.getUser())
        );
    }

    public static CategoryDto toCategoryDto(Category category){
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getProducts().stream().map(product -> DtoUtil.toProductDto(product)).collect(Collectors.toList())
        );
    }

    public static CartItemDto toCartItemDto(CartItem cartItem){
        return new CartItemDto(
                cartItem.getId(),
                DtoUtil.toCartDto(cartItem.getCart()),
                cartItem.getQuantity(),
                cartItem.getProductName(),
                cartItem.getPrice()
        );
    }

    public  static CartDto toCartDto(Cart cart){
        return new CartDto(
                cart.getId(),
                cart.getCreatedOn(),
                cart.getCartItems().stream().map(cartItem -> DtoUtil.toCartItemDto(cartItem)).collect(Collectors.toList())
        );
    }
}
