package com.backend.demo.controllers;


import com.backend.demo.models.Device;
import com.backend.demo.models.Equipment;
import com.backend.demo.repos.DeviceRepository;
import com.backend.demo.repos.EquipmentRepository;
import com.backend.demo.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceController {
    private DeviceRepository deviceRepository;
    private DeviceService deviceService;
    private EquipmentRepository equipmentRepository;


    @Autowired
    public DeviceController(DeviceRepository deviceRepository, DeviceService deviceService, EquipmentRepository equipmentRepository) {
        this.deviceRepository = deviceRepository;
        this.deviceService = deviceService;
        this.equipmentRepository = equipmentRepository;
    }


    @GetMapping(value = "/device/{id}")
    public Device findDeviceById(@PathVariable Long id) {
        return deviceRepository.findById(id).get();
    }

    @GetMapping(value = "/device")
    public List<Device> findAllDevices(){
        return (List<Device>) deviceRepository.findAll();
    }

    // TO DO: test after adding equipment

    @GetMapping(value = "/equipment{equipmentId}/device")
    public List<Device> findDevicesByEquipment(@PathVariable Long equipmentId){
      return (List<Device>) deviceRepository.findByEquipmentId(equipmentId);
    }

    @DeleteMapping(value = "/device/{id}")
    public Device deleteDeviceById(@PathVariable Long id) {
        deviceRepository.deleteById(id);
        return null;
    }

   /* @GetMapping(value = "/company/device")
    public Device findDeviceByCompany(@RequestBody Company company) {

       return
    }*/

    /*@GetMapping(value = "/deviceType/device")
    public Device findDeviceByType(@RequestBody DeviceType deviceType){
        return  Optional.of(deviceRepository.findByDeviceType_Name(deviceType)).orElse(new Device());
    }*/

    /*@GetMapping(value = "/equipment/device")
    public Device findDeviceByEquipment(@RequestBody Equipment equipment) {
        return Optional.of(deviceRepository.findByEquipmentOrderByDeviceType(equipment)).orElse(new Device());
    }*/

    @PostMapping(value = "/device/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Device> addNewDevice(@RequestBody Device device) {
        Device deviceDetails = deviceService.loadDeviceByPlace(device.getPlace());

        if (deviceDetails != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            deviceService.addDevice(device);
            return ResponseEntity.ok(device);
        }

    }
}