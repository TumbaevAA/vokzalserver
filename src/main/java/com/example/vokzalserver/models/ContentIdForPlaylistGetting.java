package com.example.vokzalserver.models;

import com.example.vokzalserver.entities.ContentEntity;

public class ContentIdForPlaylistGetting {
    private Long id;

    public static ContentIdForPlaylistGetting toModel(ContentEntity entity){
        ContentIdForPlaylistGetting model = new ContentIdForPlaylistGetting();
        
        model.id = entity.getId();

        return model;
    }

    public ContentIdForPlaylistGetting() {
    }

    public Long getId() {
        return id;
    }
}


