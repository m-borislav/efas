package com.backend.demo.controllers;


import com.backend.demo.models.Measuring;
import com.backend.demo.repos.MeasuringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MeasuringController {
    private MeasuringRepository measuringRepository;



    @Autowired
    public MeasuringController(MeasuringRepository measuringRepository) {
        this.measuringRepository = measuringRepository;
    }

    @GetMapping(value = "/measuring/{dateOfMeasuring}")
    public Measuring findMeasuringByDate (@PathVariable LocalDateTime dateOfMeasuring){
        return measuringRepository.findByDateOfMeasuring(dateOfMeasuring);
    }

    @GetMapping(value = "/measuring/{id}")
    public Measuring findMeasuringById (@PathVariable Long id){
        return measuringRepository.findById(id).get();
    }


}
