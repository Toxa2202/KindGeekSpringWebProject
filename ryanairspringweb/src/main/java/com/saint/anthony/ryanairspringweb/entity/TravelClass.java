package com.saint.anthony.ryanairspringweb.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TravelClass extends IdHolder{
    private String name;
    private String description;

    @OneToMany(mappedBy = "travelClass")
    private List<AircraftSeat> aircraftSeats = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String travellClassName) {
        this.name = travellClassName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String travelClassDescription) {
        this.description = travelClassDescription;
    }

    public List<AircraftSeat> getAircraftSeats() {
        return aircraftSeats;
    }

    public void setAircraftSeats(List<AircraftSeat> aircraftSeats) {
        this.aircraftSeats = aircraftSeats;
    }
}
