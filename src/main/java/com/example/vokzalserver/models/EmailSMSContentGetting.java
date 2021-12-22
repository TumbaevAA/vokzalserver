package com.example.vokzalserver.models;


import com.example.vokzalserver.entities.ContentEntity;

public class EmailSMSContentGetting {
    private Long id;
    private String name;
    private String content;


    public static EmailSMSContentGetting toModel(ContentEntity entity){
        EmailSMSContentGetting model = new EmailSMSContentGetting();

        model.id = entity.getId();
        model.name = entity.getName();
        model.content = entity.getContent();

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
}
