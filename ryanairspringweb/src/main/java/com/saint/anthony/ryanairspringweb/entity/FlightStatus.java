package com.saint.anthony.ryanairspringweb.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FlightStatus extends IdHolder{
    private String flightStatusName;
    private String flightStatusDetails;

    @OneToMany(mappedBy = "flightStatus")
    private List<Flight> flights = new ArrayList<>();

    public String getFlightStatusName() {
        return flightStatusName;
    }

    public void setFlightStatusName(String flightStatusName) {
        this.flightStatusName = flightStatusName;
    }

    public String getFlightStatusDetails() {
        return flightStatusDetails;
    }

    public void setFlightStatusDetails(String flightStatusDetails) {
        this.flightStatusDetails = flightStatusDetails;
    }

    @Override
    public String toString() {
        return "FlightStatus{" +
                "flightStatusId=" + super.getId() +
                ", flightStatusName='" + flightStatusName + '\'' +
                ", flightStatusDetails='" + flightStatusDetails + '\'' +
                '}';
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
