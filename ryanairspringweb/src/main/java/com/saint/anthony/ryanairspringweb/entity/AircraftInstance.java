package com.saint.anthony.ryanairspringweb.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class AircraftInstance extends IdHolder{
    private Long aircraftInstanceId;

    @ManyToOne
    private Flight flight;

    @ManyToOne
    private Aircraft aircraft;


    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Long getAircraftInstanceId() {
        return aircraftInstanceId;
    }

    public void setAircraftInstanceId(Long aircraftInstanceId) {
        this.aircraftInstanceId = aircraftInstanceId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
