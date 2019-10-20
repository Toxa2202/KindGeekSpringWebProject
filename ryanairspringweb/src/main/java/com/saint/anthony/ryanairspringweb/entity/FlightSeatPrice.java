package com.saint.anthony.ryanairspringweb.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FlightSeatPrice extends IdHolder{
    private Long seatId;
    private Double priceUSD;

    @ManyToOne
    private AircraftSeat aircraftSeat;

    @ManyToOne
    private Flight flight;

    @OneToMany(mappedBy = "flightCall")
    private List<Booking> flightCalls = new ArrayList<>();

    @OneToMany(mappedBy = "aircraftId")
    private List<Booking> aircraftIds = new ArrayList<>();

    @OneToMany(mappedBy = "seatId")
    private List<Booking> seatIds = new ArrayList<>();

    public AircraftSeat getAircraftSeat() {
        return aircraftSeat;
    }

    public void setAircraftSeat(AircraftSeat aircraftSeat) {
        this.aircraftSeat = aircraftSeat;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public Double getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(Double priceUSD) {
        this.priceUSD = priceUSD;
    }

    public List<Booking> getFlightCalls() {
        return flightCalls;
    }

    public void setFlightCalls(List<Booking> flightCalls) {
        this.flightCalls = flightCalls;
    }

    public List<Booking> getAircraftIds() {
        return aircraftIds;
    }

    public void setAircraftIds(List<Booking> aircraftIds) {
        this.aircraftIds = aircraftIds;
    }

    public List<Booking> getSeatIds() {
        return seatIds;
    }

    public void setSeatIds(List<Booking> seatIds) {
        this.seatIds = seatIds;
    }
}
