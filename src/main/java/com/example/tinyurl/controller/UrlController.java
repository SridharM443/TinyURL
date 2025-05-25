package com.example.tinyurl.controller;

import com.example.tinyurl.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/encode")
    public String encode(@RequestBody String longUrl) {
        return urlService.encode(longUrl);
    }

    @GetMapping("/decode")
    public String decode(@RequestParam String shortUrl) {
        return urlService.decode(shortUrl);
    }
}
