package com.backend.demo.services;

import com.backend.demo.exceptions.DeviceNotFoundException;
import com.backend.demo.models.Device;
import com.backend.demo.repos.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceService {
    private DeviceRepository deviceRepository;


    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

   public Device addDevice(Device device){
        Device deviceFromDb = deviceRepository.findByPlace(device.getPlace());
        if (deviceFromDb != null){
            return deviceFromDb;
        } else{
            Device newDevice = new Device();
            newDevice.setPlace(device.getPlace());
            newDevice.setDeviceType(device.getDeviceType());
            deviceRepository.save(newDevice);
            return newDevice;
        }
   }

   public Device loadDeviceByPlace(String place) throws DeviceNotFoundException {
        return deviceRepository.findByPlace(place);
   }
}
