package com.saint.anthony.ryanairspringweb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Entity
public class Country {
    @Id
    private String iataCountryCode;

    private String name;

    @OneToMany(mappedBy = "country")
    private List<Airport> airports = new ArrayList<>();

    @OneToMany(mappedBy = "country")
    private List<Client> clients = new ArrayList<>();

}
