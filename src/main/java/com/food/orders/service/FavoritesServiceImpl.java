package com.food.orders.service;

import com.food.orders.repository.FavoritesRepository;
import com.food.orders.service.interfaces.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoritesServiceImpl implements FavoritesService {

    private FavoritesRepository favoritesRepository;

    @Autowired
    public FavoritesServiceImpl(FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }
}
