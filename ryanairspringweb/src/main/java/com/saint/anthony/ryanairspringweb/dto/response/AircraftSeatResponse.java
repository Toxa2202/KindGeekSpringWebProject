package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.AircraftSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AircraftSeatResponse {
    private Long id;
    private Long seatId;
    private String aircraftModel;
    private String travelClassName;
//    private List<FlightSeatPriceResponse> flightSeatPriceResponses = new ArrayList<>();

    public AircraftSeatResponse(AircraftSeat aircraftSeat) {
        this.id = aircraftSeat.getId();
        this.seatId = aircraftSeat.getSeatId();
        this.aircraftModel = aircraftSeat.getAircraft().getModel();
        this.travelClassName = aircraftSeat.getTravelClass().getName();
//        this.flightSeatPriceResponses = aircraftSeat.getFlightSeatPrices()
//                .stream().map(FlightSeatPriceResponse::new)
//                .collect(Collectors.toList());
    }
}
