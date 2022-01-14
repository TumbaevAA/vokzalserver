package com.example.vokzalserver.models;

public class PublicationPosting {
    private Long id;
    private String name;
    private Date date;
    private String recipient;
    private String content;
    private int status;

    public PublicationPosting() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getContent() {
        return content;
    }

    public int getStatus() {
        return status;
    }
}
