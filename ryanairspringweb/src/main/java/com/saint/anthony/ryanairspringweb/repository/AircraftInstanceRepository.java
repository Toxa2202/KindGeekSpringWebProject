package com.saint.anthony.ryanairspringweb.repository;


import com.saint.anthony.ryanairspringweb.entity.AircraftInstance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftInstanceRepository extends JpaRepository<AircraftInstance, Long> {

}
