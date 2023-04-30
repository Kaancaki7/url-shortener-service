package com.kaan.urlshortener.shortener.service;

import com.kaan.urlshortener.shortener.dto.ShortenerRequestDto;
import com.kaan.urlshortener.shortener.dto.ShortenerResponseDto;

public interface ShortenerService {

    public ShortenerResponseDto shorteningUrl(ShortenerRequestDto requestDto, String email);
}
