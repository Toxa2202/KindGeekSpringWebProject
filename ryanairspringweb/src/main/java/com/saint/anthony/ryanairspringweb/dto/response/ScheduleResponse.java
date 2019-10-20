package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ScheduleResponse {
    private Long id;
    private String departureTimeGMT;
    private String arrivalTimeGMT;
    private Long directionId;
    private List<FlightResponse> flightResponses = new ArrayList<>();

    public ScheduleResponse(Schedule schedule) {
        this.id = schedule.getId();
        this.departureTimeGMT = schedule.getDepartureTimeGMT();
        this.arrivalTimeGMT = schedule.getArrivalTimeGMT();
        this.directionId = schedule.getDirection().getId();
        this.flightResponses = schedule.getFlights()
                .stream()
                .map(FlightResponse::new)
                .collect(Collectors.toList());
    }
}
