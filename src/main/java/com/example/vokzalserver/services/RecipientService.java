package com.example.vokzalserver.services;

import com.example.vokzalserver.models.Recipient;
import com.example.vokzalserver.models.RecipientsGetting;
import com.example.vokzalserver.repositories.RecipientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipientService {
    private final RecipientRepository recipientRepository;

    public RecipientService(RecipientRepository recipientRepository) {
        this.recipientRepository = recipientRepository;
    }

    public RecipientsGetting getAllRecipients(){
        return RecipientsGetting.toModel(recipientRepository.findAllPeople()
                .stream().map(Recipient::toModel).collect(Collectors.toList()),
                recipientRepository.findAllGroups().stream().map(Recipient::toModel).collect(Collectors.toList()));
    }
}
