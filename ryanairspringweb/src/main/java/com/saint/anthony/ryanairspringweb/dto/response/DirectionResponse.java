package com.saint.anthony.ryanairspringweb.dto.response;

import com.saint.anthony.ryanairspringweb.entity.Direction;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class DirectionResponse {
    private String airportName;
    private String airportCity;
    private List<ScheduleResponse> scheduleResponses = new ArrayList<>();

    public DirectionResponse(Direction direction) {
        this.airportName = direction.getDepartIataAirportCode().getAirportName();
        this.airportCity = direction.getDepartIataAirportCode().getCityName();
        this.scheduleResponses = direction.getSchedules()
                .stream()
                .map(ScheduleResponse::new)
                .collect(Collectors.toList());
    }
}
