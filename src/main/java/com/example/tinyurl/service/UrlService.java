package com.example.tinyurl.service;

import com.example.tinyurl.model.UrlMapping;
import com.example.tinyurl.repository.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {

    private static final String BASE_URL = "http://tiny.url/";
    private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 6;

    private final Random random = new Random();

    @Autowired
    private UrlMappingRepository repository;

    private String generateCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            sb.append(CHAR_SET.charAt(random.nextInt(CHAR_SET.length())));
        }
        return sb.toString();
    }

    public String encode(String longUrl) {
        Optional<UrlMapping> existing = repository.findByLongUrl(longUrl);
        if (existing.isPresent()) {
            return BASE_URL + existing.get().getShortCode();
        }

        String code;
        do {
            code = generateCode();
        } while (repository.findByShortCode(code).isPresent());

        UrlMapping mapping = new UrlMapping();
        mapping.setLongUrl(longUrl);
        mapping.setShortCode(code);
        repository.save(mapping);

        return BASE_URL + code;
    }

    public String decode(String shortUrl) {
        String code = shortUrl.replace(BASE_URL, "");
        return repository.findByShortCode(code)
                .map(UrlMapping::getLongUrl)
                .orElse(null);
    }
}
