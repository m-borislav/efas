package com.backend.demo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;
    @Column(name = "location", nullable = false, length = 100)
    private String location;
    @ManyToMany( mappedBy = "companySet")
    private Set<User> users;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Equipment> equipmentSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Equipment> getEquipmentSet() {
        return equipmentSet;
    }

    public void setEquipmentSet(Set<Equipment> equipmentSet) {
        this.equipmentSet = equipmentSet;
    }




}

