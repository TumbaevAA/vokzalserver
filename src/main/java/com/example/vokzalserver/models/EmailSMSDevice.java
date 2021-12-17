package com.example.vokzalserver.models;

import com.example.vokzalserver.entities.DeviceEntity;

import java.util.ArrayList;
import java.util.List;

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
         * Далее из каждого itemEntity создаем столько моделей, сколько у этого
         * itemEntity получателей, модели добавляем в поле items
         * */
        emailSMSDevice.item = new ArrayList<>();
        deviceEntity.getChannels().get(0).getItems().forEach(itemEntity -> {
                    for (int i = 0; i < itemEntity.getRecipients().size(); i++){
                        emailSMSDevice.item.add(EmailSMSItem.toModel(itemEntity, i));
                    }
                });

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
