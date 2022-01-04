package com.example.vokzalserver.models;

import com.example.vokzalserver.entities.DeviceEntity;

public class EmailSMSDeviceForPlaylistGetting {

    private Long id;
    private String name;
    private String description;

    public static EmailSMSDeviceForPlaylistGetting toModel(DeviceEntity entity){
        EmailSMSDeviceForPlaylistGetting model = new EmailSMSDeviceForPlaylistGetting();

        model.id = entity.getId();
        model.name = entity.getName();
        model.description = entity.getDescription();

        return model;
    }



    public EmailSMSDeviceForPlaylistGetting() {
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
}
