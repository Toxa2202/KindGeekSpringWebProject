package com.saint.anthony.ryanairspringweb.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequest {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Long phone;
    private String email;
    private String passport;
}
