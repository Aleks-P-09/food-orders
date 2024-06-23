package com.food.orders.repository;

import com.food.orders.entities.Favorites;
import com.food.orders.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites,Integer> {

    List<Favorites> findByUser(User user);

}
