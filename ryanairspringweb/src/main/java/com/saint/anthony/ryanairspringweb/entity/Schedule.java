package com.saint.anthony.ryanairspringweb.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Schedule extends IdHolder{
    private String departureTimeGMT;
    private String arrivalTimeGMT;

    @OneToMany(mappedBy = "schedule")
    private List<Flight> flights = new ArrayList<>();

    @ManyToOne
    private Direction direction;

    public String getDepartureTimeGMT() {
        return departureTimeGMT;
    }

    public void setDepartureTimeGMT(String departureTimeGMT) {
        this.departureTimeGMT = departureTimeGMT;
    }

    public String getArrivalTimeGMT() {
        return arrivalTimeGMT;
    }

    public void setArrivalTimeGMT(String arrivalTimeGMT) {
        this.arrivalTimeGMT = arrivalTimeGMT;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
