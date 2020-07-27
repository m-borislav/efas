package com.backend.demo.repos;

import com.backend.demo.models.Company;
import com.backend.demo.models.Device;
import com.backend.demo.models.Equipment;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device, Long> {

    Device findByEquipmentId(Long equipmentId);

    Device findByPlace(String place);
}
