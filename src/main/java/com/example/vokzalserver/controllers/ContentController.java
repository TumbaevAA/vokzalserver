package com.example.vokzalserver.controllers;

import com.example.vokzalserver.models.ContentPosting;
import com.example.vokzalserver.services.ContentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("Json/ContentDeviceSmsPost.json")
    public ResponseEntity saveSMS(@RequestBody ContentPosting content){
        return ResponseEntity.ok(contentService.saveOrUpdateSMS(content));
    }

    @GetMapping("Json/ContentDeviceSmsGet.json")
    public ResponseEntity getSMS(){
        return ResponseEntity.ok(contentService.getAllSMS());
    }

    @GetMapping("Json/PlaylistDeviceSms.json")
    public ResponseEntity getAllSMSPlaylists(){
        return ResponseEntity.ok(contentService.getAllSMSPlaylists());
    }
}
