package com.saint.anthony.ryanairspringweb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@ToString
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Entity
public class Flight extends IdHolder{
    @ManyToOne
    @JoinColumn(name = "flight_status_id", nullable = false)
    private FlightStatus flightStatus;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @OneToMany(mappedBy = "flight")
    private List<FlightSeatPrice> flightSeatPrices = new ArrayList<>();

    @ManyToOne
    private AircraftInstance aircraftInstance;

}
