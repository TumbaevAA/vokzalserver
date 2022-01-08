package com.example.vokzalserver.models;


import com.example.vokzalserver.entities.ContentEntity;

public class EmailSMSContentGetting {
    private Long id;
    private String name;
    private String content;
    private int status;

    public static EmailSMSContentGetting toModel(ContentEntity entity){
        EmailSMSContentGetting model = new EmailSMSContentGetting();

        model.id = entity.getId();
        model.name = entity.getName();
        model.content = entity.getContent();
        model.status = entity.getStatus();

        return model;
    }


    public EmailSMSContentGetting() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public int getStatus() {
        return status;
    }
}
