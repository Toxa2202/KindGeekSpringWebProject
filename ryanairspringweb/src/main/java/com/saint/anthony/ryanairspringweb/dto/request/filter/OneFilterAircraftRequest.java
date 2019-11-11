package com.saint.anthony.ryanairspringweb.dto.request.filter;

import com.saint.anthony.ryanairspringweb.dto.request.criteria.CriteriaForSearchAircraft;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OneFilterAircraftRequest {

    private CriteriaForSearchAircraft criteriaForSearchAircraft;
    private String firstValue;
    private String secondValue;
}
