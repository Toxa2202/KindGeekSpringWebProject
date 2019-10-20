package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.AircraftCreator;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AircraftCreatorResponse {
    private Long id;
    private String name;
    private List<AircraftResponse> aircraftResponses = new ArrayList<>();

    public AircraftCreatorResponse(AircraftCreator aircraftCreator) {
        this.id = aircraftCreator.getId();
        this.name = aircraftCreator.getName();
        this.aircraftResponses = aircraftCreator.getAircrafts()
            .stream()
            .map(AircraftResponse::new)
            .collect(Collectors.toList());
    }
}
