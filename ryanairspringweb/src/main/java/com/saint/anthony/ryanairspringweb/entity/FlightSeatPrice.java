package com.saint.anthony.ryanairspringweb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Entity
public class FlightSeatPrice {
    @Id
    private Long seatId;

    private Double priceUSD;

    @ManyToOne
    @JoinColumn(name = "aircraft_id", nullable = false)
    private AircraftSeat aircraftSeat;

    @ManyToOne
    @JoinColumn(name = "flight_call", nullable = false)
    private Flight flight;

    @OneToMany(mappedBy = "flightCall")
    private List<Booking> flightCalls = new ArrayList<>();

    @OneToMany(mappedBy = "aircraftId")
    private List<Booking> aircraftIds = new ArrayList<>();

    @OneToMany(mappedBy = "seatId")
    private List<Booking> seatIds = new ArrayList<>();

}
