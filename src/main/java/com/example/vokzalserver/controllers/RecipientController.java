package com.example.vokzalserver.controllers;

import com.example.vokzalserver.services.RecipientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipientController {

    private final RecipientService recipientService;

    public RecipientController(RecipientService recipientService) {
        this.recipientService = recipientService;
    }

    @GetMapping("Json/recipient")
    public ResponseEntity getRecipients(){
        return ResponseEntity.ok(recipientService.getAllRecipients());
    }
}
