package com.food.orders.service;

import com.food.orders.controller.template.FavoritesTemplate;
import com.food.orders.dto.FavoritesDto;
import com.food.orders.dto.util.DtoUtil;
import com.food.orders.entities.Favorites;
import com.food.orders.entities.Product;
import com.food.orders.entities.User;
import com.food.orders.repository.FavoritesRepository;
import com.food.orders.repository.ProductRepository;
import com.food.orders.repository.UserRepository;
import com.food.orders.service.interfaces.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoritesServiceImpl implements FavoritesService {

    private FavoritesRepository favoritesRepository;
    private UserRepository userRepository;

    private ProductRepository productRepository;

    @Autowired
    public FavoritesServiceImpl(FavoritesRepository favoritesRepository,
                                UserRepository userRepository,
                                ProductRepository productRepository) {
        this.favoritesRepository = favoritesRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public FavoritesDto createFavorites(FavoritesTemplate favoritesTemplate) {

        Optional<User> existingUser = userRepository.findById(favoritesTemplate.getUserId());
        if (existingUser.isEmpty()){
            throw new RuntimeException("User with id "+favoritesTemplate.getUserId()+" does not exist.");
        }
        User user = existingUser.get();

        Optional<Product> optionalProduct=productRepository.findById(favoritesTemplate.getProductId());
        if (optionalProduct.isEmpty()){
            throw new RuntimeException("Product with id "+favoritesTemplate.getProductId()+" is not found.");
        }
        Product product=optionalProduct.get();

        Favorites favorites=new Favorites();

        favorites.setUser(user);
        favorites.setProduct(product);

        user.getFavorites().add(favorites);

        favoritesRepository.saveAndFlush(favorites);

        return DtoUtil.toFavoritesDto(favorites);
    }


    @Override
    public void delete(Integer id) {
        Optional<Favorites> optionalFavorites=favoritesRepository.findById(id);
        if (optionalFavorites.isEmpty()){
            throw new RuntimeException("Favorites with id"+id+" is not found");
        }
        favoritesRepository.deleteById(id);
    }

    @Override
    public List<FavoritesDto> getByUserId(Integer userId) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isEmpty()){
            throw new RuntimeException("User with id "+userId+" does not exist.");
        }
        User user = existingUser.get();

        return favoritesRepository.findByUser(user)
                .stream()
                .map(favorites ->DtoUtil.toFavoritesDto(favorites))
                .collect(Collectors.toList());
    }
}
