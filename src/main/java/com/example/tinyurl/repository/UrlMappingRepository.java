package com.example.tinyurl.repository;

import com.example.tinyurl.model.UrlMapping;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UrlMappingRepository extends MongoRepository<UrlMapping, String> {
    Optional<UrlMapping> findByLongUrl(String longUrl);
    Optional<UrlMapping> findByShortCode(String shortCode);
}
