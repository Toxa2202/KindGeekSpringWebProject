package com.saint.anthony.ryanairspringweb.repository;


import com.saint.anthony.ryanairspringweb.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

}
