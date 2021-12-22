package com.example.vokzalserver.models;

import java.time.Duration;

public class ContentPosting {
    private Long id;
    private String name;
    private String type;
    private String content;
    private Duration duration;
    private int status;



    public ContentPosting() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public int getStatus() {
        return status;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}



