package com.example.vokzalserver.models;

import com.example.vokzalserver.entities.PublicationEntity;

import java.time.format.DateTimeFormatter;


public class EmailSMSPublicationGetting {
    private Long id;
    private String name;        //Имя контента, который содержится в publication
    private Date date;
    private String group;       //Название плана публикации
    private String recipient;   //Адрес получателя, либо название группы
    private String content;     //Содержание контента, который содержится в publication
    private int status;

    public static EmailSMSPublicationGetting toModel(PublicationEntity entity){
        EmailSMSPublicationGetting model = new EmailSMSPublicationGetting();

        model.id = entity.getId();
        model.name = entity.getContent().getName();
        model.date = new Date(String.valueOf(entity.getDateTimePlayback().getYear()),
                                String.valueOf(entity.getDateTimePlayback().getMonthValue()),
                                String.valueOf(entity.getDateTimePlayback().getDayOfMonth()),
                                entity.getDateTimePlayback().format(DateTimeFormatter.ofPattern("HH:mm")));

        model.recipient = entity.getRecipient().getAddress();
        model.content = entity.getContent().getContent();
        model.status = entity.getStatus();

        return model;
    }


    public EmailSMSPublicationGetting() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getGroup() {
        return group;
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
