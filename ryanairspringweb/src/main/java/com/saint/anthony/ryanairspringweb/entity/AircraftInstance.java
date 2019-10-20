package com.saint.anthony.ryanairspringweb.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AircraftInstance extends IdHolder{

    @OneToMany(mappedBy = "aircraftInstance")
    private List<Flight> flights = new ArrayList<>();

    @ManyToOne
    private Aircraft aircraft;


    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}
