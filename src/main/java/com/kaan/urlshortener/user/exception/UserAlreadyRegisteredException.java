package com.kaan.urlshortener.user.exception;

import com.kaan.urlshortener.errorhandler.exception.ApplicationException;
import com.kaan.urlshortener.errorhandler.ErrorCode;
import org.springframework.http.HttpStatus;

public class UserAlreadyRegisteredException extends ApplicationException {

    public UserAlreadyRegisteredException() {
        super(ErrorCode.ERROR_USER_ALREADY_REGISTERED.toString(),
                "User already registered",
                HttpStatus.BAD_REQUEST);
    }
}
