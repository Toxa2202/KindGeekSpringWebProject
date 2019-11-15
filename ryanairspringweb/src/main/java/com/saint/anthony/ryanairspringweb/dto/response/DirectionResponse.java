package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.Direction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DirectionResponse {
    private String departureAirportName;
    private String departureAirportCity;
    private String arrivalAirportName;
    private String arrivalAirportCity;
//    private List<ScheduleResponse> scheduleResponses = new ArrayList<>();

    public DirectionResponse(Direction direction) {
        this.departureAirportName = direction.getDepartIataAirportCode().getName();
        this.departureAirportCity = direction.getArrivalIataAirprotCode().getCity();
        this.arrivalAirportName = direction.getDepartIataAirportCode().getName();
        this.arrivalAirportCity = direction.getArrivalIataAirprotCode().getCity();
//        this.scheduleResponses = direction.getSchedules()
//                .stream()
//                .map(ScheduleResponse::new)
//                .collect(Collectors.toList());
    }
}
