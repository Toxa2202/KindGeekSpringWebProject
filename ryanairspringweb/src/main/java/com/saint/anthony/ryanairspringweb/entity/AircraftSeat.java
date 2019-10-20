package com.saint.anthony.ryanairspringweb.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AircraftSeat extends IdHolder{
    private Long seatId;

    @ManyToOne
    private Aircraft aircraft;

    @ManyToOne
    private TravelClass travelClass;

    @OneToMany(mappedBy = "aircraftSeat")
    private List<FlightSeatPrice> flightSeatPrices = new ArrayList<>();

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public TravelClass getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(TravelClass travelClass) {
        this.travelClass = travelClass;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}