package com.food.orders.service.interfaces;

import com.food.orders.controller.template.CreateProductTemplate;
import com.food.orders.controller.template.UpdateProductTemplate;
import com.food.orders.dto.ProductDto;
import com.food.orders.entities.Category;
import com.food.orders.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
//    List<ProductDto> getAllProducts();

    ProductDto createProduct(CreateProductTemplate createProductTemplate);

    ProductDto updateProduct(UpdateProductTemplate updateProductTemplate,Integer id);

    List<ProductDto> getAllProductsByCategory(Integer id);

    List<ProductDto> getAllProducts();
}
