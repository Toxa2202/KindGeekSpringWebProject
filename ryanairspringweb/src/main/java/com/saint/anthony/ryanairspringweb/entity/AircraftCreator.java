package com.saint.anthony.ryanairspringweb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter @Setter
@ToString
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Entity
public class AircraftCreator extends IdHolder{

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "aircraftCreator")
    private List<Aircraft> aircrafts = new ArrayList<>();

}
