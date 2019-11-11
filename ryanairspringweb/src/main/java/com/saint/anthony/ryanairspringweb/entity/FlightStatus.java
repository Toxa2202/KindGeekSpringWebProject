package com.saint.anthony.ryanairspringweb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Entity;
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
public class FlightStatus extends IdHolder{

    private String flightStatusName;
    private String flightStatusDetails;

    @OneToMany(mappedBy = "flightStatus")
    private List<Flight> flights = new ArrayList<>();

}
