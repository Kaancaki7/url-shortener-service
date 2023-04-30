package com.kaan.urlshortener.user.dto;

import com.kaan.urlshortener.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDto toUserDto(User user) {
        return new UserDto()
                .setEmail(user.getEmail())
                .setId(user.getId());
    }
}
