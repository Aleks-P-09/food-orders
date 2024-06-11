package com.food.orders.repository;

import com.food.orders.controller.template.CreateProductTemplate;
import com.food.orders.dto.CategoryDto;
import com.food.orders.dto.ProductDto;
import com.food.orders.entities.Category;
import com.food.orders.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategory(Category category);

    Optional<Product> findByName(String name);
}
