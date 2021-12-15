package com.example.vokzalserver.controllers;

import com.example.vokzalserver.services.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Json/SMSDevice.json")
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    private ResponseEntity getAllSMSDevices(){
        return ResponseEntity.ok(deviceService.getAllSMSDevices());
    }

    
}
