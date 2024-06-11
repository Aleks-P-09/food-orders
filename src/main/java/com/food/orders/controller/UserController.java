package com.food.orders.controller;

import com.food.orders.controller.template.UserTemplate;
import com.food.orders.dto.CategoryDto;
import com.food.orders.dto.UserDto;
import com.food.orders.entities.Category;
import com.food.orders.entities.User;
import com.food.orders.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserTemplate userTemplate) {
        return ResponseEntity.ok(this.userService.createUser(userTemplate));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserTemplate userTemplate, @PathVariable("id")Integer id){
        return ResponseEntity.ok(this.userService.updateUser(userTemplate, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable ("id") Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}