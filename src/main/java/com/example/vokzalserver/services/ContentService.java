package com.example.vokzalserver.services;

import com.example.vokzalserver.entities.ContentEntity;
import com.example.vokzalserver.models.ContentPosting;
import com.example.vokzalserver.repositories.ContentRepository;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

    private final ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }


    public ContentEntity saveOrUpdateSMS(ContentPosting content){
        content.setType("SMS");

        //Если id == null, то контент новый, статус по умолчанию - не проверен
        if (content.getId() == null){
            content.setStatus(2);
        }

        return contentRepository.save(ContentEntity.toEntity(content));
    }
}
