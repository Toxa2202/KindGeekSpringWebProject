package com.saint.anthony.ryanairspringweb.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Direction extends IdHolder{
    @ManyToOne
    // Name of this need to write at the another end
    private Airport departIataAirportCode;

    @ManyToOne
    private Airport arrivalIataAirprotCode;

    @OneToMany(mappedBy = "direction")
    private List<Schedule> schedules = new ArrayList<>();

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Airport getDepartIataAirportCode() {
        return departIataAirportCode;
    }

    public void setDepartIataAirportCode(Airport departIataAirportCode) {
        this.departIataAirportCode = departIataAirportCode;
    }

    public Airport getArrivalIataAirprotCode() {
        return arrivalIataAirprotCode;
    }

    public void setArrivalIataAirprotCode(Airport arrivalIataAirprotCode) {
        this.arrivalIataAirprotCode = arrivalIataAirprotCode;
    }
}
