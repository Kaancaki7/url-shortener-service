package com.kaan.urlshortener.auth.service;

import com.kaan.urlshortener.auth.dto.LoginCredentialDto;
import com.kaan.urlshortener.user.dto.SessionDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    public SessionDto login(LoginCredentialDto loginCredential) throws Exception;
}
