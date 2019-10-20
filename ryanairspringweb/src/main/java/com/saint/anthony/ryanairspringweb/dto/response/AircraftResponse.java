package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.Aircraft;
import com.saint.anthony.ryanairspringweb.entity.AircraftSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AircraftResponse {
    private Long id;
    private String model;
    private String aircraftCreatorName;
    private List<AircraftInstanceResponse> aircraftInstanceResponses = new ArrayList<>();
    private List<AircraftSeatResponse> aircraftSeatResponses = new ArrayList<>();

    public AircraftResponse(Aircraft aircraft) {
        this.id = aircraft.getId();
        this.model = aircraft.getModel();
        this.aircraftCreatorName = aircraft.getAircraftCreator().getName();
        this.aircraftInstanceResponses = aircraft.getAircraftInstances()
                .stream()
                .map(AircraftInstanceResponse::new)
                .collect(Collectors.toList());
        this.aircraftSeatResponses = aircraft.getAircraftSeats()
                .stream().map(AircraftSeatResponse::new)
                .collect(Collectors.toList());
    }
}

// Ready to Use