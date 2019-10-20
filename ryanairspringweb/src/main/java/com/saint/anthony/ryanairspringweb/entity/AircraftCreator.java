package com.saint.anthony.ryanairspringweb.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AircraftCreator extends IdHolder{

    private String name;

    @OneToMany(mappedBy = "aircraftCreator")
    private List<Aircraft> aircrafts = new ArrayList<>();

    public AircraftCreator() {
    }

    public AircraftCreator(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(List<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }

    @Override
    public String toString() {
        return "AircraftCreator{" +
                "id=" + super.getId() +
                ", name='" + name + '\'' +
                '}';
    }

}
