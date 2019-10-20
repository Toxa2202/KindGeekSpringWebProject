package com.saint.anthony.ryanairspringweb.repository;

import com.saint.anthony.ryanairspringweb.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
