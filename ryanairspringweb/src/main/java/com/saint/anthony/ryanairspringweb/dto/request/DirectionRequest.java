package com.saint.anthony.ryanairspringweb.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DirectionRequest {
    private Long id;
    private String departureAirportName;
    private String departureAirportCity;
    private String arrivalAirportName;
    private String arrivalAirportCity;
}
