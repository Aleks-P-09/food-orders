package com.food.orders.controller;

import com.food.orders.controller.template.CategoryTemplate;
import com.food.orders.dto.CategoryDto;
import com.food.orders.entities.Category;
import com.food.orders.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping
    public ResponseEntity <CategoryDto> createCategory(@RequestBody CategoryTemplate categoryTemplate){
        return ResponseEntity.ok(this.categoryService.createCategory(categoryTemplate));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryTemplate categoryTemplate, @PathVariable ("id") Integer id){
        return ResponseEntity.ok(this.categoryService.updateCategory(categoryTemplate, id));
    }



}
