package com.example.vokzalserver.models;

import com.example.vokzalserver.entities.ContentEntity;
import com.example.vokzalserver.entities.PlaylistEntity;

import java.util.List;
import java.util.stream.Collectors;

public class EmailSMSPlaylistGetting {
    private Long id;
    private String name;
    private int status;
    private String description;
    private List<ContentIdForPlaylistGetting> content;


    public static EmailSMSPlaylistGetting toModel(ContentEntity entity){


        //TODO исключение, если параметр не плейлист


        EmailSMSPlaylistGetting model = new EmailSMSPlaylistGetting();

        model.id = entity.getId();
        model.name = entity.getName();
        model.status = entity.getStatus();
        model.description = entity.getContent();
        model.content = entity.getPlaylistContent().stream().map(ContentIdForPlaylistGetting::toModel).collect(Collectors.toList());

        return model;
    }




    public EmailSMSPlaylistGetting() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public List<ContentIdForPlaylistGetting> getContent() {
        return content;
    }
}


