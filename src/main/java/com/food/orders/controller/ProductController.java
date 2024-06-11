package com.food.orders.controller;

import com.food.orders.controller.template.CreateProductTemplate;
import com.food.orders.controller.template.UpdateProductTemplate;
import com.food.orders.dto.CategoryDto;
import com.food.orders.dto.ProductDto;
import com.food.orders.dto.util.DtoUtil;
import com.food.orders.entities.Category;
import com.food.orders.entities.Product;
import com.food.orders.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<List<ProductDto>> getAllProductsByCategory(@PathVariable ("categoryId")Integer id) {
        return ResponseEntity.ok(productService.getAllProductsByCategory(id));
    }

//    @GetMapping
//    public ResponseEntity<List<ProductDto>> getAllProducts() {
//        return ResponseEntity.ok(productService.getAllProducts());
//    }

    @PostMapping
    public ResponseEntity <ProductDto> createProduct(@RequestBody CreateProductTemplate createProductTemplate){
        return ResponseEntity.ok(this.productService.createProduct(createProductTemplate));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody UpdateProductTemplate updateProductTemplate, @PathVariable("id")Integer id){
        return ResponseEntity.ok(this.productService.updateProduct(updateProductTemplate, id));
    }
}
