package com.saint.anthony.ryanairspringweb.dto.request.filter;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FilterAircraftRequest {

    List<OneFilterAircraftRequest> oneFilterAircraftRequests = new ArrayList<>();
}
