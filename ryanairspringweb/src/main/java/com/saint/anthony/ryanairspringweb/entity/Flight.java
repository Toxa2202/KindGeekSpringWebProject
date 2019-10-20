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

    @ManyToOne
    private AircraftInstance aircraftInstance;

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
}
