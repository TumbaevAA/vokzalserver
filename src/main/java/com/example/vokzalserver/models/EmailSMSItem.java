package com.example.vokzalserver.models;

import com.example.vokzalserver.entities.ItemEntity;
import com.example.vokzalserver.entities.RecipientEntity;

import java.time.format.DateTimeFormatter;
import java.util.List;


public class EmailSMSItem {
    private long id;
    private String name;
    private Date date;
    private String group;
    private String recipient;
    private String content;
    private int status;

    public static EmailSMSItem toModel(ItemEntity entity){
        EmailSMSItem model = new EmailSMSItem();

        model.id = entity.getId();
        model.name = entity.getContent().getName();
        model.date = new Date(String.valueOf(entity.getDateTimePlayback().getYear()),
                                String.valueOf(entity.getDateTimePlayback().getMonthValue()),
                                String.valueOf(entity.getDateTimePlayback().getDayOfMonth()),
                                entity.getDateTimePlayback().format(DateTimeFormatter.ofPattern("HH:mm")));

        /*Достаем список получателей. Если получатель один, то записываем его адрес
        в recipient, если больше, то ищем название группы получателей
        и записываем в group
        */
        List<RecipientEntity> recipients = entity.getRecipients();
        if(recipients.size() == 1){
            model.group = "-";
            model.recipient = recipients.get(0).getAddress();
        }
//TODO Алгоритм, который будет брать группы всех получателей и среди них искать одинаковую для всех
        else{
            model.recipient = "-";
            model.group = recipients.get(0).getGroupsThatRecipientBelongsTo().get(0).getName();
        }

        model.content = entity.getContent().getContent();
        model.status = entity.getStatus();

        return model;
    }


    public EmailSMSItem() {
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
