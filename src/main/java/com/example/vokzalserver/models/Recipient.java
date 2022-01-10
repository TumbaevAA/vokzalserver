package com.example.vokzalserver.models;

import com.example.vokzalserver.entities.RecipientEntity;

public class Recipient {
    private Long id;
    private String address;

    public static Recipient toModel(RecipientEntity entity){
        Recipient model = new Recipient();

        model.id = entity.getId();
        model.address = entity.getAddress();

        return model;
    }

    public Recipient() {
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }
}
