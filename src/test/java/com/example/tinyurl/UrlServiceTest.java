package com.example.tinyurl;

import com.example.tinyurl.service.UrlService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UrlServiceTest {

    @Autowired
    private UrlService service;

    @Test
    public void testEncodeDecode() {
        String longUrl = "https://openai.com";
        String shortUrl = service.encode(longUrl);
        String decodedUrl = service.decode(shortUrl);
        assertEquals(longUrl, decodedUrl);
    }
}
