package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.AircraftInstance;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AircraftInstanceResponse {
    private Long id;
    private String aircraftModel;

    public AircraftInstanceResponse(AircraftInstance aircraftInstance) {
        this.id = aircraftInstance.getId();
        this.aircraftModel = aircraftInstance.getAircraft().getModel();
    }
}
