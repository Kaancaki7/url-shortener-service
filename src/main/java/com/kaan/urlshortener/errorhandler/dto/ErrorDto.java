package com.kaan.urlshortener.errorhandler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorDto {
    private String errorCode;
    private String errorMessage;
}


