package com.kaan.urlshortener.user.service;


import com.kaan.urlshortener.user.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    public User signup(User user);

    public User findByEmail(String email);
}
