package com.saint.anthony.ryanairspringweb.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Airport extends IdHolder {
    private String iataAirportCode;
    private String airportName;
    private String cityName;

    @ManyToOne
    private Country iataCountryCode;

    @OneToMany(mappedBy = "departIataAirportCode")
    private List<Direction> departures = new ArrayList<>();

    @OneToMany(mappedBy = "arrivalIataAirprotCode")
    private List<Direction> arrivals = new ArrayList<>();

    public String getIataAirportCode() {
        return iataAirportCode;
    }

    public void setIataAirportCode(String iataAirportCode) {
        this.iataAirportCode = iataAirportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Direction> getDepartures() {
        return departures;
    }

    public void setDepartures(List<Direction> directions) {
        this.departures = directions;
    }

    public List<Direction> getArrivals() {
        return arrivals;
    }

    public void setArrivals(List<Direction> arrivals) {
        this.arrivals = arrivals;
    }

    public Country getIataCountryCode() {
        return iataCountryCode;
    }

    public void setIataCountryCode(Country iataCountryCode) {
        this.iataCountryCode = iataCountryCode;
    }
}
