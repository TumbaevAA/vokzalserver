package com.example.vokzalserver.models;

import com.example.vokzalserver.entities.ContentEntity;

import java.util.List;
import java.util.stream.Collectors;

public class EmailSMSPlaylist {
    private Long id;
    private String name;
    private int status;
    private String description;
    private List<ContentIdForPlaylist> content;


    public static EmailSMSPlaylist toModel(ContentEntity entity){

        EmailSMSPlaylist model = new EmailSMSPlaylist();

        model.id = entity.getId();
        model.name = entity.getName();
        model.status = entity.getStatus();
        model.description = entity.getContent();
        model.content = entity.getPlaylistContent().stream().map(ContentIdForPlaylist::toModel).collect(Collectors.toList());

        return model;
    }




    public EmailSMSPlaylist() {
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

    public List<ContentIdForPlaylist> getContent() {
        return content;
    }
}


