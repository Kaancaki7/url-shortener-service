package com.kaan.urlshortener.user.exception;

import com.kaan.urlshortener.errorhandler.ErrorCode;
import com.kaan.urlshortener.errorhandler.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ApplicationException {

    public UserNotFoundException() {
        super(ErrorCode.ERROR_USER_NOT_FOUND.toString(),
                "Please check your credential", HttpStatus.UNAUTHORIZED);
    }
}
