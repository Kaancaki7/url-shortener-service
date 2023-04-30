package com.kaan.urlshortener.shortener.exception;

import com.kaan.urlshortener.errorhandler.ErrorCode;
import com.kaan.urlshortener.errorhandler.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class KeyAliasRetrievalFailedException extends ApplicationException {


    public KeyAliasRetrievalFailedException() {
        super(ErrorCode.KGS_FAILURE.toString(), "KGS FAILURE", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
