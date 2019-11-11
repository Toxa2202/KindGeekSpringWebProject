package com.saint.anthony.ryanairspringweb.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TravelClassRequest {
//    private Long id;
    @NotBlank
    @NotNull
    private String name;

    private String description;
}
