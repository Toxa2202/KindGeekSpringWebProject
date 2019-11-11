package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.Aircraft;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AircraftResponse {
    private Long id;
    private String model;
    private String creator;
//    private List<AircraftInstanceResponse> aircraftInstanceResponses = new ArrayList<>();
//    private List<AircraftSeatResponse> aircraftSeatResponses = new ArrayList<>();

    public AircraftResponse(Aircraft aircraft) {
        this.id = aircraft.getId();
        this.model = aircraft.getModel();
        this.creator = aircraft.getAircraftCreator().getName();
//        this.aircraftInstanceResponses = aircraft.getAircraftInstances()
//                .stream()
//                .map(AircraftInstanceResponse::new)
//                .collect(Collectors.toList());
//        this.aircraftSeatResponses = aircraft.getAircraftSeats()
//                .stream().map(AircraftSeatResponse::new)
//                .collect(Collectors.toList());
    }
}

// Ready to Use