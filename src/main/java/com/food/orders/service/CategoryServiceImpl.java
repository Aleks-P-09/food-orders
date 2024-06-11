package com.food.orders.service;

import com.food.orders.controller.template.CategoryTemplate;
import com.food.orders.dto.CategoryDto;
import com.food.orders.dto.util.DtoUtil;
import com.food.orders.entities.Category;
import com.food.orders.repository.CategoryRepository;
import com.food.orders.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<CategoryDto> getAllCategories(){
        return categoryRepository.findAll()
                .stream()
                .map(category -> DtoUtil.toCategoryDto(category))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto createCategory(CategoryTemplate categoryTemplate) {
        Category category = new Category();

        category.setName(categoryTemplate.getName());
        categoryRepository.saveAndFlush(category);
        return DtoUtil.toCategoryDto(category);
    }

    @Override
    public CategoryDto updateCategory(CategoryTemplate categoryTemplate, Integer id) {
         Optional<Category> optionalCategory=categoryRepository.findById(id);
         if (optionalCategory.isEmpty()){
             throw new RuntimeException("Category with id "+ id+ " is not found.");
         }
         Category category = optionalCategory.get();

         category.setName(categoryTemplate.getName());
         categoryRepository.saveAndFlush(category);
         return DtoUtil.toCategoryDto(category);
    }


}
