package com.example.vokzalserver.services;

import com.example.vokzalserver.entities.DeviceEntity;
import com.example.vokzalserver.models.EmailSMSDeviceGetting;
import com.example.vokzalserver.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;


    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<EmailSMSDeviceGetting> getAllSMSDevices(){
        List<DeviceEntity> devicesEntity = deviceRepository.findAllByType("SMS");

        /*Для каждого элемента deviceEntity используем функцию EmailSMSDeviceGetting.toModel()*/
        return devicesEntity.stream().map(EmailSMSDeviceGetting::toModel).collect(Collectors.toList());

    }
}
