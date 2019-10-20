package com.saint.anthony.ryanairspringweb.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightSeatPriceRequest {
    private Long id;
    private Long seatId;
    private Double priceUSD;
}
