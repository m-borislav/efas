package com.backend.demo.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Measuring {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (name = "dateOfMeasuring", nullable = false)
    private LocalDateTime dateOfMeasuring;
    @Column (name = "description", nullable = false, length = 300)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Device device;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateOfMeasuring() {
        return dateOfMeasuring;
    }

    public void setDateOfMeasuring(LocalDateTime dateOfMeasuring) {
        this.dateOfMeasuring = dateOfMeasuring;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}