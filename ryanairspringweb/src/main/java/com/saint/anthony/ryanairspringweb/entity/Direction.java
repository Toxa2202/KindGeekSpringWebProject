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

@Getter
@Setter
@ToString
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Entity
public class Direction extends IdHolder{
    @ManyToOne
    @JoinColumn(name = "departure_iata_airport_code", nullable = false)
    // Name of this need to write at the another end
    private Airport departIataAirportCode;

    @ManyToOne
    @JoinColumn(name = "arrival_iata_airport_code", nullable = false)
    private Airport arrivalIataAirprotCode;

    @OneToMany(mappedBy = "direction")
    private List<Schedule> schedules = new ArrayList<>();

}
