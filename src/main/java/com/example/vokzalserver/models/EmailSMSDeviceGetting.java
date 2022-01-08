package com.example.vokzalserver.models;

import com.example.vokzalserver.entities.DeviceEntity;

import java.util.List;
import java.util.stream.Collectors;

public class EmailSMSDeviceGetting {
    private Long id;
    private String name;
    private String description;
    private int status;
    private List<EmailSMSItemGetting> publication;

    public static EmailSMSDeviceGetting toModel(DeviceEntity entity){
        EmailSMSDeviceGetting model = new EmailSMSDeviceGetting();
        model.id = entity.getId();
        model.name = entity.getName();
        model.description = entity.getDescription();
        model.status = entity.getStatus();

        /*У смс- и email-устройств один канал, поэтому берем нулевой элемент в списке.
          Далее из каждого itemEntity создаем модель, модели добавляем в поле item */
        model.publication = entity.getChannels().get(0).getItems().
                stream().map(EmailSMSItemGetting::toModel).collect(Collectors.toList());

        return model;
    }


    public EmailSMSDeviceGetting() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStatus() {
        return status;
    }

    public List<EmailSMSItemGetting> getPublication() {
        return publication;
    }
}
