package com.kaan.urlshortener.shortener.service;

import com.kaan.urlshortener.shortener.dto.KeyAliasDto;
import com.kaan.urlshortener.shortener.dto.ShortenerRequestDto;
import com.kaan.urlshortener.shortener.dto.ShortenerResponseDto;
import com.kaan.urlshortener.shortener.exception.KeyAliasRetrievalFailedException;
import com.kaan.urlshortener.shortener.model.ShortUrl;
import com.kaan.urlshortener.shortener.repository.ShortUrlRepository;
import com.kaan.urlshortener.user.model.User;
import com.kaan.urlshortener.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShortenerServiceImpl implements ShortenerService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${urlshortener.keygenerationservice.baseurl}")
    private String kgsBaseUrl;

    @Value("${urlshortener.redirection.baseurl}")
    private String redirectionBaseUrl;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShortUrlRepository shortUrlRepository;


    @Override
    public ShortenerResponseDto shorteningUrl(ShortenerRequestDto requestDto, String email) {
        ResponseEntity<KeyAliasDto> keyAliasResponse = restTemplate.getForEntity(kgsBaseUrl + "/retrieval", KeyAliasDto.class);
        KeyAliasDto keyAlias = keyAliasResponse.getBody();

        if (keyAlias == null) {
            throw new KeyAliasRetrievalFailedException();
        }

        User user = null;
        if (email != null) {
            user = userRepository.findByEmail(email);
        }

        ShortUrl shortUrl = new ShortUrl(keyAlias.getKey(), requestDto.getOriginalUrl(), user);
        shortUrl = shortUrlRepository.save(shortUrl);

        return new ShortenerResponseDto(shortUrl.getOriginalUrl(), redirectionBaseUrl + shortUrl.getAlias());
    }
}
