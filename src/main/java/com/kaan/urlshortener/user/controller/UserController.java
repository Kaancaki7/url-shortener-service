package com.kaan.urlshortener.user.controller;

import com.kaan.urlshortener.user.dto.UserDto;
import com.kaan.urlshortener.user.dto.UserMapper;
import com.kaan.urlshortener.user.model.User;
import com.kaan.urlshortener.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public UserDto registerUser(@RequestBody User user) {
        User registeredUser = userService.signup(user);

        return UserMapper.toUserDto(registeredUser);
    }
}
