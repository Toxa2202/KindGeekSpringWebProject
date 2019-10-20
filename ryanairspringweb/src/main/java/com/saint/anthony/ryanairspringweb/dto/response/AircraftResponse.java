package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.Aircraft;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AircraftResponse {
    private Long id;
    private String model;
    private String aircraftCreatorName;

    public AircraftResponse(Aircraft aircraft) {
        this.id = aircraft.getId();
        this.model = aircraft.getModel();
        this.aircraftCreatorName = aircraft.getAircraftCreator().getName();
    }
}

// Ready to Use