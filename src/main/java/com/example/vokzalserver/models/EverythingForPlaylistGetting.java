package com.example.vokzalserver.models;

import com.example.vokzalserver.entities.ContentEntity;
import com.example.vokzalserver.entities.DeviceEntity;

import java.util.List;
import java.util.stream.Collectors;

public class EverythingForPlaylistGetting {
    private List<EmailSMSDeviceForPlaylistGetting> device;
    private List<EmailSMSPlaylistGetting> playlist;
    private List<EmailSMSContentGetting> content;

    public static EverythingForPlaylistGetting toModel(List<DeviceEntity> devicesEntity,
                                                       List<ContentEntity> contentPlaylistEntity,
                                                       List<ContentEntity> contentEntity){
        EverythingForPlaylistGetting model = new EverythingForPlaylistGetting();

        model.device = devicesEntity.stream().map(EmailSMSDeviceForPlaylistGetting::toModel).collect(Collectors.toList());
        model.playlist = contentPlaylistEntity.stream().map(EmailSMSPlaylistGetting::toModel).collect(Collectors.toList());
        model.content = contentEntity.stream().map(EmailSMSContentGetting::toModel).collect(Collectors.toList());

        return model;
    }

    public EverythingForPlaylistGetting() {
    }

    public List<EmailSMSDeviceForPlaylistGetting> getDevice() {
        return device;
    }

    public List<EmailSMSPlaylistGetting> getPlaylist() {
        return playlist;
    }

    public List<EmailSMSContentGetting> getContent() {
        return content;
    }
}


