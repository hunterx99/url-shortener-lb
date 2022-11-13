package com.example.urlshortenerlb.Entity;

import lombok.Data;

@Data
public class UrlShortenerEntity {
    private Long id;
    private String fullUrl;
    private String shortUrl;
    private String createdAt;
    private String expireAt;
    private String status;
}
