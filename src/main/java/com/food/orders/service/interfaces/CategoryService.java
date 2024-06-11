package com.food.orders.service.interfaces;

import com.food.orders.controller.template.CategoryTemplate;
import com.food.orders.dto.CategoryDto;
import com.food.orders.entities.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategories();

    CategoryDto createCategory(CategoryTemplate categoryTemplate);

    CategoryDto updateCategory(CategoryTemplate categoryTemplate, Integer id);


}
