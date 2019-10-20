package com.saint.anthony.ryanairspringweb.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightStatusRequest {
    private Long id;
    private String flightStatusName;
    private String flightStatusDetails;
}
