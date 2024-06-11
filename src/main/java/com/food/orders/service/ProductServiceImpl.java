package com.food.orders.service;

import com.food.orders.controller.template.CreateProductTemplate;
import com.food.orders.controller.template.UpdateProductTemplate;
import com.food.orders.dto.ProductDto;
import com.food.orders.dto.util.DtoUtil;
import com.food.orders.entities.Category;
import com.food.orders.entities.Product;
import com.food.orders.entities.User;
import com.food.orders.repository.CategoryRepository;
import com.food.orders.repository.ProductRepository;
import com.food.orders.repository.UserRepository;
import com.food.orders.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              UserRepository userRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

//    public List<ProductDto> getAllProducts() {
//        return productRepository.findAll()
//                .stream()
//                .map(product -> DtoUtil.toProductDto(product))
//                .collect(Collectors.toList());
//    }

    @Override
    public ProductDto createProduct(CreateProductTemplate createProductTemplate) {

       Optional<Product> existingProduct = productRepository.findByName(createProductTemplate.getName());
        if (existingProduct.isPresent()){
            throw new RuntimeException("Product with name "+ createProductTemplate.getName()+" already exist");
        }

        Optional<User> existingUser = userRepository.findById(createProductTemplate.getUserId());
        if (existingUser.isEmpty()){
            throw new RuntimeException("User with id "+createProductTemplate.getUserId()+" does not exist.");
        }

        Optional<Category> existingCategory = categoryRepository.findById(createProductTemplate.getCategoryId());
        if (existingCategory.isEmpty()){
            throw new RuntimeException("Category with id "+createProductTemplate.getCategoryId()+"does not exist.");
        }

        Product product=new Product();

        product.setName(createProductTemplate.getName());
        product.setPrice(createProductTemplate.getPrice());
        product.setAvailable(createProductTemplate.isAvailable());
        product.setDescription(createProductTemplate.getDescription());
        product.setImageUrl(createProductTemplate.getImageUrl());

        User user = existingUser.get();
        product.setCreatedBy(user);

        Category category = existingCategory.get();
        product.setCategory(category);

        product.setCreatedOn(LocalDateTime.now());

        productRepository.saveAndFlush(product);
        return DtoUtil.toProductDto(product);
    }

    @Override
    public ProductDto updateProduct(UpdateProductTemplate updateProductTemplate, Integer id) {
        Optional<Product> optionalProduct=productRepository.findById(id);
        if (optionalProduct.isEmpty()){
            throw new RuntimeException("Product with id "+id+" is not found.");
        }
        Product product=optionalProduct.get();

        Optional<Category> existingCategory=categoryRepository.findById(updateProductTemplate.getCategoryId());
        if (existingCategory.isEmpty()){
            throw new RuntimeException("Category with id "+updateProductTemplate.getCategoryId()+" does not exist.");
        }

        Category category=existingCategory.get();

        product.setName(updateProductTemplate.getName());
        product.setPrice(updateProductTemplate.getPrice());
        product.setAvailable(updateProductTemplate.isAvailable());
        product.setDescription(updateProductTemplate.getDescription());
        product.setImageUrl(updateProductTemplate.getImageUrl());

        product.setCategory(category);
        productRepository.saveAndFlush(product);
        return DtoUtil.toProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProductsByCategory(Integer id) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isEmpty()){
            throw new RuntimeException("Category with id "+id+" is not found.");
        }
        Category category=existingCategory.get();
        return productRepository.findByCategory(category)
                .stream()
                .map(product -> DtoUtil.toProductDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> DtoUtil.toProductDto(product))
                .collect(Collectors.toList());
    }
}
