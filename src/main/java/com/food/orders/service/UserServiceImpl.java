package com.food.orders.service;

import com.food.orders.controller.template.UserTemplate;
import com.food.orders.dto.UserDto;
import com.food.orders.dto.util.DtoUtil;
import com.food.orders.entities.Favorites;
import com.food.orders.entities.Product;
import com.food.orders.entities.User;
import com.food.orders.repository.UserRepository;
import com.food.orders.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserTemplate userTemplate) {
        User user = new User();

        user.setFirstName(userTemplate.getFirstName());
        user.setLastName(userTemplate.getLastName());
        user.setPhone(userTemplate.getPhone());
        user.setAddress(userTemplate.getAddress());
        user.setRole(userTemplate.getRole());

        user.setCreatedBy(userTemplate.getFirstName()+" "+userTemplate.getLastName());
        user.setCreatedOn(LocalDateTime.now());

        userRepository.saveAndFlush(user);
        return DtoUtil.toUserDto(user);
    }

    @Override
    public UserDto updateUser(UserTemplate userTemplate, Integer id) {
        Optional<User> optionalUser=userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new RuntimeException("User with id "+id+" is not found");
        }
        User user = optionalUser.get();

        user.setFirstName(userTemplate.getFirstName());
        user.setLastName(userTemplate.getLastName());
        user.setPhone(userTemplate.getPhone());
        user.setAddress(userTemplate.getAddress());
        user.setRole(userTemplate.getRole());

        userRepository.saveAndFlush(user);
        return DtoUtil.toUserDto(user);
    }

    @Override
    public UserDto getUserById(Integer id) {
        Optional<User> optionalUser=userRepository.findById(id);
        if (optionalUser.isEmpty()){
            throw new RuntimeException("User with id "+id+" is not found");
        }
        User user=optionalUser.get();

        return DtoUtil.toUserDto(user);
    }


}
