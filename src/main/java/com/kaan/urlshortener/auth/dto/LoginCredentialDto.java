package com.kaan.urlshortener.auth.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginCredentialDto {
    private String email;
    private String password;
}
