package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.FlightStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class FlightStatusResponse {
    private Long id;
    private String flightStatusName;
    private String flightStatusDetails;
    private List<FlightResponse> flightResponses = new ArrayList<>();

    public FlightStatusResponse(FlightStatus flightStatus) {
        this.id = flightStatus.getId();
        this.flightStatusName = flightStatus.getFlightStatusName();
        this.flightStatusDetails = flightStatus.getFlightStatusDetails();
        this.flightResponses = flightStatus.getFlights()
                .stream()
                .map(FlightResponse::new)
                .collect(Collectors.toList());
    }
}
