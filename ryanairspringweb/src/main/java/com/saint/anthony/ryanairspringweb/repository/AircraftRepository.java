package com.saint.anthony.ryanairspringweb.repository;


import com.saint.anthony.ryanairspringweb.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

}
