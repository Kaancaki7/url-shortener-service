package com.kaan.urlshortener.shortener.repository;

import com.kaan.urlshortener.shortener.model.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Integer> {
    public ShortUrl findByAlias(String alias);
}
