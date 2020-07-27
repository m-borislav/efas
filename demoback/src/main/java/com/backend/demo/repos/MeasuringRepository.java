package com.backend.demo.repos;

import com.backend.demo.models.Measuring;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface MeasuringRepository extends CrudRepository<Measuring, Long> {

    Measuring findByDateOfMeasuring(LocalDateTime dateOfMeasuring);
    Measuring findByDevice_Id(Long device_id);
}

