package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.Country;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CountryResponse {
    private String iataCountryCode;
    private String name;
//    private List<ClientResponse> clientResponses = new ArrayList<>();
//    private List<AirportResponse> airportResponses = new ArrayList<>();

    public CountryResponse(Country country) {
        this.iataCountryCode = country.getIataCountryCode();
        this.name = country.getName();
//        this.clientResponses = country.getClients()
//                .stream()
//                .map(ClientResponse::new)
//                .collect(Collectors.toList());
//        this.airportResponses = country.getAirports()
//                .stream()
//                .map(AirportResponse::new)
//                .collect(Collectors.toList());
    }
}
