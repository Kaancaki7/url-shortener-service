package com.kaan.urlshortener.redirection.service;

import com.kaan.urlshortener.shortener.model.ShortUrl;
import com.kaan.urlshortener.shortener.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedirectionService {

    @Autowired
    private ShortUrlRepository shortUrlRepository;

    public String getOriginalUrlFromAlias(String alias) throws NullPointerException {
        ShortUrl shortUrl = shortUrlRepository.findByAlias(alias);
        return shortUrl.getOriginalUrl();
    }
}
