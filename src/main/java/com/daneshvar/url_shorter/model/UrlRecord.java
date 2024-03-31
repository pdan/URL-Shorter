package com.daneshvar.url_shorter.model;

import jakarta.persistence.*;
import org.apache.commons.lang3.RandomStringUtils;

@Entity
public class UrlRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    @Column(unique = true)
    private String key;

    public UrlRecord() {}

    public String getKey() {
        return this.key;
    }
    public String getUrlByKey() {
        return this.url;
    }
    private String generateRandomKey() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public UrlRecord(String url) {
        this.url = url;
        this.key = generateRandomKey();
    }


}
