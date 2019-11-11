package com.saint.anthony.ryanairspringweb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter @Setter
@ToString
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Entity
public class AircraftSeat extends IdHolder{
    private Long seatId;

    @ManyToOne
    @JoinColumn(name = "aircraft_id", nullable = false)
    private Aircraft aircraft;

    @ManyToOne
    @JoinColumn(name = "travel_class_id", nullable = false)
    private TravelClass travelClass;

    @OneToMany(mappedBy = "aircraftSeat")
    private List<FlightSeatPrice> flightSeatPrices = new ArrayList<>();

}