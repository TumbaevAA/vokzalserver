package com.example.vokzalserver.services;

import com.example.vokzalserver.entities.DeviceEntity;
import com.example.vokzalserver.models.EmailSMSDevice;
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

    public List<EmailSMSDevice> getAllSMSDevices(){
        List<DeviceEntity> devicesEntity = deviceRepository.findAllByType("SMS");

        /*Для каждого элемента deviceEntity используем функцию EmailSMSDevice.toModel()*/
        return devicesEntity.stream().map(EmailSMSDevice::toModel).collect(Collectors.toList());

    }
}
