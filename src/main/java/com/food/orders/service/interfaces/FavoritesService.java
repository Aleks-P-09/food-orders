package com.food.orders.service.interfaces;

import com.food.orders.controller.template.FavoritesTemplate;
import com.food.orders.dto.FavoritesDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavoritesService {
    FavoritesDto createFavorites(FavoritesTemplate favoritesTemplate);

//    FavoritesDto createFavorites(FavoritesTemplateId favoritesTemplateId);

//    FavoritesDto updateFavorites(FavoritesTemplate favoritesTemplate);


    void delete(Integer id);

    List<FavoritesDto> getByUserId(Integer userId);
}
