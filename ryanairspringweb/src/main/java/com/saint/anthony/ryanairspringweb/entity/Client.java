package com.saint.anthony.ryanairspringweb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Entity
public class Client extends IdHolder{

    private String firstName;
    private String middleName;
    private String lastName;

    @Column(unique = true)
    private Long phone;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String passport;

    @OneToMany(mappedBy = "client")
    private List<Booking> bookings = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "iata_country_code", nullable = false)
    private Country country;

}