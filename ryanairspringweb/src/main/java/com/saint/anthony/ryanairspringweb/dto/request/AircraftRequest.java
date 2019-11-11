package com.saint.anthony.ryanairspringweb.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AircraftRequest {
    //    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 25)
    private String model;
}
