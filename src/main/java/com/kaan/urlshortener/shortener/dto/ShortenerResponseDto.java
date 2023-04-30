package com.kaan.urlshortener.shortener.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ShortenerResponseDto {

    private String originalUrl;
    private String shortUrl;
}
