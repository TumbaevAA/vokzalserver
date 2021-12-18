package com.example.vokzalserver.models;

import com.example.vokzalserver.entities.DeviceEntity;

import java.util.List;
import java.util.stream.Collectors;

public class EmailSMSDevice {
    private Long id;
    private String name;
    private String description;
    private int status;
    private List<EmailSMSItem> item;

    public static EmailSMSDevice toModel(DeviceEntity deviceEntity){
        EmailSMSDevice emailSMSDevice = new EmailSMSDevice();
        emailSMSDevice.id = deviceEntity.getId();
        emailSMSDevice.name = deviceEntity.getName();
        emailSMSDevice.description = deviceEntity.getDescription();
        emailSMSDevice.status = deviceEntity.getStatus();

        /*У смс- и email-устройств один канал, поэтому берем нулевой элемент в списке.
          Далее из каждого itemEntity создаем столько модель, модели добавляем в поле item */
        emailSMSDevice.item = deviceEntity.getChannels().get(0).getItems().
                stream().map(EmailSMSItem::toModel).collect(Collectors.toList());

        return emailSMSDevice;
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

    public List<EmailSMSItem> getItem() {
        return item;
    }
}
