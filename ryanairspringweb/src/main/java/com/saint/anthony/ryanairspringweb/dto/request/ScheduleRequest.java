package com.saint.anthony.ryanairspringweb.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleRequest {
    private Long id;
    private String departureTimeGMT;
    private String arrivalTimeGMT;
}
