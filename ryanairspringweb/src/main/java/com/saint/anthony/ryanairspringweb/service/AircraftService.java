package com.saint.anthony.ryanairspringweb.service;

import com.saint.anthony.ryanairspringweb.dto.request.AircraftRequest;
import com.saint.anthony.ryanairspringweb.dto.response.AircraftResponse;
import com.saint.anthony.ryanairspringweb.entity.Aircraft;
import com.saint.anthony.ryanairspringweb.exceptions.WrongInputDataException;
import com.saint.anthony.ryanairspringweb.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AircraftService {
    @Autowired
    private AircraftRepository repository;

    // GET ALL
    public List<AircraftResponse> getAircrafts() {
        return repository.findAll()
                .stream()
                .map(AircraftResponse::new)
                .collect(Collectors.toList());
    }

    // GET ONE
    public AircraftResponse getById(Long id) {
        Optional<Aircraft> aircraftOptional = repository.findById(id);
        return new AircraftResponse(getEntityObjectById(id));
    }

    // SAVE
    public void save(AircraftRequest aircraftRequest) {
        Aircraft aircraft = new Aircraft();
        aircraft.setModel(aircraftRequest.getModel());
        repository.save(aircraft);
    }

    // UPDATE
    public void update(Long id, AircraftRequest aircraftRequest) {
        Aircraft aircraft = getEntityObjectById(id);
        aircraft.setModel(aircraftRequest.getModel());
        repository.save(aircraft);
    }

    // DELETE ONE
    public void delete(Long id) {
        Aircraft aircraft = getEntityObjectById(id);
        if (aircraft.getAircraftInstances().isEmpty()) {
            repository.delete(aircraft);
        } else {
            throw new WrongInputDataException("Aircraft with id " + id + " has some instances.");
        }
    }

    private Aircraft getEntityObjectById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Can't find aircraft with id " + id));
    }
}
