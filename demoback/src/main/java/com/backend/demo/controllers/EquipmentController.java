package com.backend.demo.controllers;

import com.backend.demo.models.Equipment;
import com.backend.demo.repos.EquipmentRepository;
import com.backend.demo.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EquipmentController {
    private EquipmentRepository equipmentRepository;
    private EquipmentService equipmentService;

    @Autowired

    public EquipmentController(EquipmentRepository equipmentRepository, EquipmentService equipmentService) {
        this.equipmentRepository = equipmentRepository;
        this.equipmentService = equipmentService;
    }

    @PostMapping(value = "/equipment/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Equipment> addNewEquipment(@RequestBody Equipment equipment){
        Equipment equipmentDetails = equipmentService.loadDeviceByLocation(equipment.getLocation());

        if (equipmentDetails != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            equipmentService.addEquipment(equipment);
            return ResponseEntity.ok(equipment);
        }
    }

    @DeleteMapping(value = "/equipment/delete/{id}")
    public Equipment deleteDeviceById(@PathVariable Long id) {
        equipmentRepository.deleteById(id);
        return null;
    }
}
