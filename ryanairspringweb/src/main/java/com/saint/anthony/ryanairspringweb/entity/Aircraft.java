package com.saint.anthony.ryanairspringweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Aircraft extends IdHolder{

    private String model;

    @ManyToOne
    private AircraftCreator aircraftCreator;

    @OneToMany(mappedBy = "aircraft")
    private List<AircraftInstance> aircraftInstances = new ArrayList<>();

    @OneToMany(mappedBy = "aircraft")
    private List<AircraftSeat> aircraftSeats = new ArrayList<>();

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public AircraftCreator getAircraftCreator() {
        return aircraftCreator;
    }

    public void setAircraftCreator(AircraftCreator aircraftCreator) {
        this.aircraftCreator = aircraftCreator;
    }

    public List<AircraftSeat> getAircraftSeats() {
        return aircraftSeats;
    }

    public void setAircraftSeats(List<AircraftSeat> aircraftSeats) {
        this.aircraftSeats = aircraftSeats;
    }

    public List<AircraftInstance> getAircraftInstances() {
        return aircraftInstances;
    }

    public void setAircraftInstances(List<AircraftInstance> aircraftInstances) {
        this.aircraftInstances = aircraftInstances;
    }
}
