package com.backend.demo.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "place", nullable = false, unique = true, length = 50)
    private String place;
    @Column(name = "deviceType", nullable = false, length = 50)
    private String deviceType;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Measuring> measuringSet;

/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="deviceType_id", unique = true, nullable = false, updatable = false)
    private DeviceType deviceType;*/

    @ManyToOne(targetEntity = Equipment.class)
    private Equipment equipment;

    public String getDeviceType() {
        return Optional.ofNullable(deviceType).orElse("");
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Set<Measuring> getMeasuringSet() {
        return measuringSet;
    }

    public void setMeasuringSet(Set<Measuring> measuringSet) {
        this.measuringSet = measuringSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return Optional.ofNullable(place).orElse("");
    }

    public void setPlace(String place) {
        this.place = place;
    }


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
