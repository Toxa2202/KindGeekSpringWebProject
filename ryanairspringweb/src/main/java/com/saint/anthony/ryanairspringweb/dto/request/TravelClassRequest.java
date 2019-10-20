package com.saint.anthony.ryanairspringweb.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TravelClassRequest {
    private Long id;
    private String name;
    private String description;
}
