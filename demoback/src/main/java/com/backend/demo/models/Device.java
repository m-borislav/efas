package com.backend.demo.models;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "place", nullable = false, unique = true, length = 50)
    private String place;
    @Column(name = "deviceType", nullable = false, length = 50)
    private String deviceType;
    private double amperage;
    private double pressure;
    private double wetness;

/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="deviceType_id", unique = true, nullable = false, updatable = false)
    private DeviceType deviceType;*/

    @ManyToOne(targetEntity = Equipment.class)
    private Equipment equipment;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return id.equals(device.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +  '}';
    }
}
