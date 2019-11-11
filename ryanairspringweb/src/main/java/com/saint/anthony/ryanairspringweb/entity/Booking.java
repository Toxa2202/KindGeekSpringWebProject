package com.saint.anthony.ryanairspringweb.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Getter @Setter
@ToString
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Entity
public class Booking extends IdHolder{

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "flight_call", nullable = false)
    private FlightSeatPrice flightCall;

    @ManyToOne
    @JoinColumn(name = "aircraft_id", nullable = false)
    private FlightSeatPrice aircraftId;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private FlightSeatPrice seatId;

}
