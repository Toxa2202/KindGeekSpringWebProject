package com.saint.anthony.ryanairspringweb.repository;

import com.saint.anthony.ryanairspringweb.entity.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightStatusRepository extends JpaRepository<FlightStatus, Long> {

}
