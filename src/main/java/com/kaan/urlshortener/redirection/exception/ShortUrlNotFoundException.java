package com.kaan.urlshortener.redirection.exception;

import com.kaan.urlshortener.errorhandler.ErrorCode;
import com.kaan.urlshortener.errorhandler.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class ShortUrlNotFoundException extends ApplicationException {

    public ShortUrlNotFoundException() {
        super(ErrorCode.ERROR_SHORT_URL_NOT_FOUND.toString(), "Not found", HttpStatus.NOT_FOUND);
    }
}
