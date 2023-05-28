package com.example.springframeworklearn.models.section1.restapi;

import org.springframework.stereotype.Component;

@Component
public class Currency {
    private String url;
    private String username;
    private String key;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
