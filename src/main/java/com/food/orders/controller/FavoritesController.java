package com.food.orders.controller;

import com.food.orders.controller.template.FavoritesTemplate;
import com.food.orders.dto.FavoritesDto;
import com.food.orders.service.interfaces.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {

    private FavoritesService favoritesService;

    @Autowired
    public FavoritesController(FavoritesService favoritesService) {
        this.favoritesService = favoritesService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<FavoritesDto>> getByUserId(@PathVariable ("id") Integer userId) {
        return ResponseEntity.ok(favoritesService.getByUserId(userId));
    }

    @PostMapping
    public ResponseEntity <FavoritesDto> createFavorites(@RequestBody FavoritesTemplate favoritesTemplate){
        return ResponseEntity.ok(this.favoritesService.createFavorites(favoritesTemplate));
    }


    @DeleteMapping("/delete/{favoritesId}")
    public void delete(@PathVariable("favoritesId") Integer id){
        favoritesService.delete(id);
    }
}

