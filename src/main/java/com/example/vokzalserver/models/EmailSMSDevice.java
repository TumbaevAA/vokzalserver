package com.example.vokzalserver.models;

import com.example.vokzalserver.entities.DeviceEntity;

import java.util.ArrayList;
import java.util.List;

public class EmailSMSDevice {
    private Long id;
    private String name;
    private String description;
    private String status;
    private String statusText;
    private List<EmailSMSItem> item;

    public static EmailSMSDevice toModel(DeviceEntity deviceEntity){
        EmailSMSDevice emailSMSDevice = new EmailSMSDevice();
        emailSMSDevice.id = deviceEntity.getId();
        emailSMSDevice.name = deviceEntity.getName();
        emailSMSDevice.description = deviceEntity.getDescription();
        emailSMSDevice.status = deviceEntity.getStatus();
        emailSMSDevice.statusText = deviceEntity.getStatusText();

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

    public String getStatus() {
        return status;
    }

    public String getStatusText() {
        return statusText;
    }

    public List<EmailSMSItem> getItem() {
        return item;
    }
}
