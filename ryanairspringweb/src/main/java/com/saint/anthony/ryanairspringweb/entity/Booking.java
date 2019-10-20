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
}
