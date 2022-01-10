package com.example.vokzalserver.models;

import com.example.vokzalserver.repositories.RecipientRepository;

import java.util.List;

public class RecipientsGetting {
    List<Recipient> people;
    List<Recipient> groups;

    public RecipientsGetting() {
    }

    public static RecipientsGetting toModel(List<Recipient> people, List<Recipient> groups){
        RecipientsGetting entity = new RecipientsGetting();

        entity.people = people;
        entity.groups = groups;

        return entity;
    }

    public List<Recipient> getPeople() {
        return people;
    }

    public List<Recipient> getGroups() {
        return groups;
    }
}
