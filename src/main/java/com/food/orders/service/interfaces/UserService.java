package com.food.orders.service.interfaces;


import com.food.orders.controller.template.UserTemplate;
import com.food.orders.dto.UserDto;
import com.food.orders.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDto createUser(UserTemplate user);

    UserDto updateUser(UserTemplate userTemplate, Integer id);

    UserDto getUserById(Integer id);


}
