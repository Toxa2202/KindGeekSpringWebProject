package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponse {
    private Long id;
    private Double priceUSD;
    private String clientLastName;
    private String clientPassport;

    public BookingResponse(Booking booking) {
        this.id = booking.getId();
        this.priceUSD = booking.getFlightCall().getPriceUSD();
        this.clientLastName = booking.getClient().getLastName();
        this.clientPassport = booking.getClient().getPassport();
    }

}
