package com.example.vokzalserver.controllers;

import com.example.vokzalserver.models.PublicationPosting;
import com.example.vokzalserver.services.PublicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicationController {
    private final PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @PostMapping("Json/SmsMessage")
    public ResponseEntity savePublicationWithNewContent(@RequestBody PublicationPosting publication){
        try{
            return ResponseEntity.ok(publicationService.savePublicationWithNewContent(publication));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
