package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.TravelClass;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class TravelClassResponse {
    private Long id;
    private String name;
    private String description;
    private List<AircraftSeatResponse> aircraftSeatResponses = new ArrayList<>();

    public TravelClassResponse(TravelClass travelClass) {
        this.id = travelClass.getId();
        this.name = travelClass.getName();
        this.description = travelClass.getDescription();
        this.aircraftSeatResponses = travelClass.getAircraftSeats()
                .stream()
                .map(AircraftSeatResponse::new)
                .collect(Collectors.toList());
    }
}
