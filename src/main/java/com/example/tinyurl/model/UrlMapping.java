package com.example.tinyurl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "url_mappings")
public class UrlMapping {
    @Id
    private String id;
    private String longUrl;
    private String shortCode;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getLongUrl() { return longUrl; }
    public void setLongUrl(String longUrl) { this.longUrl = longUrl; }

    public String getShortCode() { return shortCode; }
    public void setShortCode(String shortCode) { this.shortCode = shortCode; }
}
