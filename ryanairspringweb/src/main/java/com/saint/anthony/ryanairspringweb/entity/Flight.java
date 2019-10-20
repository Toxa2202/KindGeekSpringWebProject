package com.saint.anthony.ryanairspringweb.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Flight extends IdHolder{
    @ManyToOne
    private FlightStatus flightStatus;

    @ManyToOne
    private Schedule schedule;

    @OneToMany(mappedBy = "flight")
    private List<FlightSeatPrice> flightSeatPrices = new ArrayList<>();

    @OneToMany(mappedBy = "flight")
    private List<AircraftInstance> aircraftInstances;

    public Schedule getScheduleId() {
        return schedule;
    }

    public void setScheduleId(Schedule scheduleId) {
        this.schedule = scheduleId;
    }

    public List<FlightSeatPrice> getFlightSeatPrices() {
        return flightSeatPrices;
    }

    public void setFlightSeatPrices(List<FlightSeatPrice> flightSeatPrices) {
        this.flightSeatPrices = flightSeatPrices;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public List<AircraftInstance> getAircraftInstances() {
        return aircraftInstances;
    }

    public void setAircraftInstances(List<AircraftInstance> aircraftInstances) {
        this.aircraftInstances = aircraftInstances;
    }
}
