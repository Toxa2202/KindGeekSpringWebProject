package com.saint.anthony.ryanairspringweb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Country {
    @Id
    private String iataCountryCode;

    private String name;

    @OneToMany(mappedBy = "iataCountryCode")
    private List<Airport> airports = new ArrayList<>();

    @OneToMany(mappedBy = "country")
    private List<Client> clients = new ArrayList<>();

    public String getIataCountryCode() {
        return iataCountryCode;
    }

    public void setIataCountryCode(String iataCountryCode) {
        this.iataCountryCode = iataCountryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String countryName) {
        this.name = countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "iataCountryCode='" + iataCountryCode + '\'' +
                ", countryName='" + name + '\'' +
                '}';
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
