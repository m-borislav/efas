package com.backend.demo.services;

import com.backend.demo.dto.DeviceDto;
import com.backend.demo.exceptions.DeviceNotFoundException;
import com.backend.demo.models.Device;
import com.backend.demo.repos.DeviceRepository;
import com.backend.demo.repos.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeviceService {
    private DeviceRepository deviceRepository;
    private EquipmentRepository equipmentRepository;


    @Autowired
    public DeviceService(DeviceRepository deviceRepository, EquipmentRepository equipmentRepository) {
        this.deviceRepository = deviceRepository;
        this.equipmentRepository = equipmentRepository;
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

   public Device amperageMeasuring(DeviceDto newDevice){
        Device device = Device.builder()
                .id(null)
                .amperage(newDevice.getAmperage())
                .pressure(newDevice.getPressure())
                .wetness(newDevice.getWetness())
                .build();
        return device;
   }
}
