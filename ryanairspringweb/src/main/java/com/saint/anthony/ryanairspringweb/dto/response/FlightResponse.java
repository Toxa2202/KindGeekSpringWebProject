package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.Flight;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class FlightResponse {
    private Long id;
    private String flightStatusName;
    private List<FlightSeatPriceResponse> flightSeatPriseResponses = new ArrayList<>();
    private  List<AircraftInstanceResponse> aircraftInstanceResponses = new ArrayList<>();

    public FlightResponse(Flight flight) {
        this.id = flight.getId();
        this.flightStatusName = flight.getFlightStatus().getFlightStatusName();
        this.flightSeatPriseResponses = flight.getFlightSeatPrices()
                .stream()
                .map(FlightSeatPriceResponse::new)
                .collect(Collectors.toList());
        this.aircraftInstanceResponses = flight.getAircraftInstances()
                .stream()
                .map(AircraftInstanceResponse::new)
                .collect(Collectors.toList());
    }
}
