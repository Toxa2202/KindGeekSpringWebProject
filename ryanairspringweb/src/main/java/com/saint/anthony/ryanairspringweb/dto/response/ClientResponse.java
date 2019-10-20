package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.Client;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ClientResponse {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Long phone;
    private String email;
    private String passport;
    private String countryName;
    private List<BookingResponse> bookingResponses = new ArrayList<>();

    public ClientResponse(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.phone = client.getPhone();
        this.email = client.getEmail();
        this.passport = client.getPassport();
        this.countryName = client.getCountry().getName();
        this.bookingResponses = client.getBookings()
                .stream()
                .map(BookingResponse::new)
                .collect(Collectors.toList());
    }
}
