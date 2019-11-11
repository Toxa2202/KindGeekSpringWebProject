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
import java.util.Set;

@Getter @Setter
@ToString
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Entity
public class Aircraft extends IdHolder{

    @Column(unique = true)
    private String model;

    @ManyToOne()//fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "aircraft_creator_id")
    private AircraftCreator aircraftCreator;

    @OneToMany(mappedBy = "aircraft")
    private List<AircraftInstance> aircraftInstances = new ArrayList<>();

    @OneToMany(mappedBy = "aircraft")
    private List<AircraftSeat> aircraftSeats = new ArrayList<>();

}
