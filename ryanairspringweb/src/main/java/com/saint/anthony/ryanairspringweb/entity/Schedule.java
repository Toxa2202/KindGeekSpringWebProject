package com.saint.anthony.ryanairspringweb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Schedule extends IdHolder{
    private String departureTimeGMT;
    private String arrivalTimeGMT;

    @OneToMany(mappedBy = "schedule")
    private List<Flight> flights = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "direction_id", nullable = false)
    private Direction direction;

}
