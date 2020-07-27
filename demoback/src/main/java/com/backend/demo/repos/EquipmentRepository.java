package com.backend.demo.repos;

import com.backend.demo.models.Equipment;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentRepository extends CrudRepository<Equipment, Long> {

    Equipment findByLocation(String location);
}
