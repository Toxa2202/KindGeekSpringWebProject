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
public class Airport {
    @Id
    private String iataAirportCode;

    private String name;
    private String city;

    @ManyToOne
    @JoinColumn(name = "iata_country_code", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "departIataAirportCode")
    private List<Direction> departures = new ArrayList<>();

    @OneToMany(mappedBy = "arrivalIataAirprotCode")
    private List<Direction> arrivals = new ArrayList<>();

}
