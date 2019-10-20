package com.saint.anthony.ryanairspringweb.entity;

import javax.persistence.*;

@Entity
public class Booking extends IdHolder{

    @ManyToOne
    private Client client;

    @ManyToOne
    private FlightSeatPrice flightCall;

    @ManyToOne
    private FlightSeatPrice aircraftId;

    @ManyToOne
    private FlightSeatPrice seatId;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public FlightSeatPrice getFlightCall() {
        return flightCall;
    }

    public void setFlightCall(FlightSeatPrice flightCall) {
        this.flightCall = flightCall;
    }

    public FlightSeatPrice getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(FlightSeatPrice aircraftId) {
        this.aircraftId = aircraftId;
    }

    public FlightSeatPrice getSeatId() {
        return seatId;
    }

    public void setSeatId(FlightSeatPrice seatId) {
        this.seatId = seatId;
    }
}
