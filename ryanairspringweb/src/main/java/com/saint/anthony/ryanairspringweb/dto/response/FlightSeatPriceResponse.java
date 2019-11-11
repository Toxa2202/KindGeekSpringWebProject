package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.FlightSeatPrice;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class FlightSeatPriceResponse {
    private Long id;
    private Long seatId;
    private Double priceUSD;
    private Long flightCall;
    private Long aircraftId;
//    private List<BookingResponse> bookingResponses = new ArrayList<>();

    public FlightSeatPriceResponse(FlightSeatPrice flightSeatPrice) {
        this.id = flightSeatPrice.getSeatId();
        this.seatId = flightSeatPrice.getSeatId();
        this.priceUSD = flightSeatPrice.getPriceUSD();
        this.aircraftId = flightSeatPrice.getAircraftSeat().getId();
        this.flightCall = flightSeatPrice.getFlight().getId();
//        this.bookingResponses = flightSeatPrice.getFlightCalls()
//                .stream()
//                .map(BookingResponse::new)
//                .collect(Collectors.toList());
    }
}
