package com.saint.anthony.ryanairspringweb.repository;

import com.saint.anthony.ryanairspringweb.dto.response.AircraftCreatorResponse;
import com.saint.anthony.ryanairspringweb.entity.AircraftCreator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AircraftCreatorRepository extends JpaRepository<AircraftCreator, Long> {
    List<AircraftCreator> findAllByNameLike(String name);

    Page<AircraftCreator> findAllByNameLike(String name, Pageable pageable);

    @Query("select ac from AircraftCreator ac where ac.name =:name")
    List<AircraftCreator> findByName(@Param("name") String name);
}
