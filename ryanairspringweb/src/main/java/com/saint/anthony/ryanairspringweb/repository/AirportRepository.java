package com.saint.anthony.ryanairspringweb.repository;


import com.saint.anthony.ryanairspringweb.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, String> {

}
