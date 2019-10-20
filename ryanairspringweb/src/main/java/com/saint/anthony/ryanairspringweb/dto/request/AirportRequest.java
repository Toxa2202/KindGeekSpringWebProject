package com.saint.anthony.ryanairspringweb.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportRequest {
    private Long id;
    private String iataAirportCode;
    private String airportName;
    private String cityName;
}
