package com.example.vokzalserver.models;

import com.example.vokzalserver.entities.ContentEntity;

public class ContentIdForPlaylist {
    private Long id;

    public static ContentIdForPlaylist toModel(ContentEntity entity){
        ContentIdForPlaylist model = new ContentIdForPlaylist();
        
        model.id = entity.getId();

        return model;
    }

    public ContentIdForPlaylist() {
    }

    public Long getId() {
        return id;
    }
}


