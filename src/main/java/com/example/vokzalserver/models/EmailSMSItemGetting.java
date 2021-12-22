package com.example.vokzalserver.models;

import com.example.vokzalserver.entities.ItemEntity;

import java.time.format.DateTimeFormatter;


public class EmailSMSItemGetting {
    private Long id;
    private String name;        //Имя контента, который содержится в item
    private Date date;
    private String group;       //Название плана публикации TODO изменить название поля, чтоб не путаться
    private String recipient;   //Адрес получателя, либо название группы
    private String content;     //Содержание контента, который содержится в item
    private int status;

    public static EmailSMSItemGetting toModel(ItemEntity entity){
        EmailSMSItemGetting model = new EmailSMSItemGetting();

        model.id = entity.getId();
        model.name = entity.getContent().getName();
        model.date = new Date(String.valueOf(entity.getDateTimePlayback().getYear()),
                                String.valueOf(entity.getDateTimePlayback().getMonthValue()),
                                String.valueOf(entity.getDateTimePlayback().getDayOfMonth()),
                                entity.getDateTimePlayback().format(DateTimeFormatter.ofPattern("HH:mm")));

        /*Достаем группу. Если группа null, то получатель один, достаем адрес получателя.
        Если имя группы не null, то добавляем имя группы в модель
        */
        if(entity.getGroup() == null){
            model.recipient = entity.getRecipients().get(0).getAddress();
        }
        else{
            model.recipient = entity.getGroup().getName();
        }

        model.content = entity.getContent().getContent();
        model.status = entity.getStatus();

        return model;
    }


    public EmailSMSItemGetting() {
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
