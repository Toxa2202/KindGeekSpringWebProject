package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.Flight;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightResponse {
    private Long id;
    private String flightStatusName;
    private String departureGMT;
    private String departureAirport;
    private String arrivalAirport;
    private Long aircraftInstanceId;
//    private List<FlightSeatPriceResponse> flightSeatPriseResponses = new ArrayList<>();

    public FlightResponse(Flight flight) {
        this.id = flight.getId();
        this.departureAirport = flight.getSchedule().getDirection().getDepartIataAirportCode().getName();
        this.arrivalAirport = flight.getSchedule().getDirection().getArrivalIataAirprotCode().getName();
        this.flightStatusName = flight.getFlightStatus().getFlightStatusName();
        this.departureGMT = flight.getSchedule().getDepartureTimeGMT();
        this.aircraftInstanceId = flight.getAircraftInstance().getAircraftInstanceId();
//        this.flightSeatPriseResponses = flight.getFlightSeatPrices()
//                .stream()
//                .map(FlightSeatPriceResponse::new)
//                .collect(Collectors.toList());
    }
}
