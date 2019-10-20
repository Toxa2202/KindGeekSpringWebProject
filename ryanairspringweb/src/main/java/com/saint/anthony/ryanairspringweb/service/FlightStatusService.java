package com.saint.anthony.ryanairspringweb.service;

import com.saint.anthony.ryanairspringweb.dto.request.FlightStatusRequest;
import com.saint.anthony.ryanairspringweb.dto.response.FlightStatusResponse;
import com.saint.anthony.ryanairspringweb.entity.FlightStatus;
import com.saint.anthony.ryanairspringweb.exceptions.WrongInputDataException;
import com.saint.anthony.ryanairspringweb.repository.FlightStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightStatusService {
    @Autowired
    private FlightStatusRepository repository;

    // GET ALL
    public List<FlightStatusResponse> flightStatuses() {
        return repository.findAll()
                .stream()
                .map(FlightStatusResponse::new)
                .collect(Collectors.toList());
    }

    // GET ONE
    public FlightStatusResponse getById(Long id) {
        Optional<FlightStatus> flightStatusOptional = repository.findById(id);
        return new FlightStatusResponse(getEntityObjectById(id));
    }

    // SAVE
    public void save(FlightStatusRequest request) {
        FlightStatus flightStatus = new FlightStatus();
        flightStatus.setId(request.getId());
        repository.save(flightStatus);
    }

    // UPDATE
    public void update(Long id, FlightStatusRequest request) {
        FlightStatus flightStatus = getEntityObjectById(id);
        flightStatus.setId(request.getId());
        repository.save(flightStatus);
    }

    // DELETE ONE
    public void delete(Long id) {
        FlightStatus flightStatus = getEntityObjectById(id);
        if (flightStatus.getFlights().isEmpty()) {
            repository.delete(flightStatus);
        } else {
            throw new WrongInputDataException("FlightStatus with id " + id + " has some instances.");
        }
    }

    private FlightStatus getEntityObjectById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Can't find flightStatus with id " + id));
    }
}
