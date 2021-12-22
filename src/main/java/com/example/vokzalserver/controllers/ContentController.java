package com.example.vokzalserver.controllers;

import com.example.vokzalserver.models.ContentPosting;
import com.example.vokzalserver.services.ContentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("Json/ContentDeviceSmsPost")
    public ResponseEntity saveSMSContent(@RequestBody ContentPosting content){
        return ResponseEntity.ok(contentService.saveOrUpdateSMS(content));
    }
}
