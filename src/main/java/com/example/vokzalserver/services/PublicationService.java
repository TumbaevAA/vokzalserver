package com.example.vokzalserver.services;

import com.example.vokzalserver.entities.*;
import com.example.vokzalserver.models.ContentPosting;
import com.example.vokzalserver.models.PublicationPosting;
import com.example.vokzalserver.repositories.ContentRepository;
import com.example.vokzalserver.repositories.DeviceRepository;
import com.example.vokzalserver.repositories.PublicationRepository;
import com.example.vokzalserver.repositories.RecipientRepository;
import org.springframework.stereotype.Service;

@Service
public class PublicationService {

        private final ContentRepository contentRepository;
        private final DeviceRepository deviceRepository;
        private final RecipientRepository recipientRepository;
        private final PublicationRepository publicationRepository;

    public PublicationService(ContentRepository contentRepository, DeviceRepository deviceRepository,
                              RecipientRepository recipientRepository, PublicationRepository publicationRepository) {
        this.contentRepository = contentRepository;
        this.deviceRepository = deviceRepository;
        this.recipientRepository = recipientRepository;
        this.publicationRepository = publicationRepository;
    }

    public PublicationEntity savePublicationWithNewContent(PublicationPosting publication){

        DeviceEntity device = deviceRepository.findById(publication.getId()).get();

        ContentEntity content = ContentEntity.toEntity(new ContentPosting(null, publication.getName(),
                "SMS", publication.getContent(), null, 2));

        RecipientEntity recipient = recipientRepository.getByAddress(publication.getRecipient());

        PublicationEntity publicationEntity = (PublicationEntity.toEntity(device.getChannels().get(0),content,
                recipient, publication));

        contentRepository.save(content);

        publicationRepository.save(publicationEntity);

        return publicationEntity;
    }
}
