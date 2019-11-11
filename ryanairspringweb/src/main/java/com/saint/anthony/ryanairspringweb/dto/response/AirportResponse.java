package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.Airport;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AirportResponse {
    private String iataAirportCode;
    private String airportName;
    private String cityName;
    private String countryName;
//    private List<DirectionResponse> departures = new ArrayList<>();
//    private List<DirectionResponse> arrivals = new ArrayList<>();

    public AirportResponse(Airport airport) {
        this.iataAirportCode = airport.getIataAirportCode();
        this.airportName = airport.getName();
        this.cityName = airport.getCity();
        this.countryName = airport.getCountry().getName();
//        this.departures = airport.getDepartures()
//                .stream()
//                .map(DirectionResponse::new)
//                .collect(Collectors.toList());
//        this.arrivals = airport.getArrivals()
//                .stream()
//                .map(DirectionResponse::new)
//                .collect(Collectors.toList());
    }
}
