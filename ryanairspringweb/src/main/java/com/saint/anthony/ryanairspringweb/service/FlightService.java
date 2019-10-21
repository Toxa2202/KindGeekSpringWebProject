package com.saint.anthony.ryanairspringweb.service;

import com.saint.anthony.ryanairspringweb.dto.request.FlightRequest;
import com.saint.anthony.ryanairspringweb.dto.response.FlightResponse;
import com.saint.anthony.ryanairspringweb.entity.Flight;
import com.saint.anthony.ryanairspringweb.exceptions.WrongInputDataException;
import com.saint.anthony.ryanairspringweb.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    private FlightRepository repository;

    // GET ALL
    public List<FlightResponse> getFlights() {
        return repository.findAll()
                .stream()
                .map(FlightResponse::new)
                .collect(Collectors.toList());
    }

    // GET ONE
    public FlightResponse getById(Long id) {
        Optional<Flight> flightOptional = repository.findById(id);
        return new FlightResponse(getEntityObjectById(id));
    }

    // SAVE
    public void save(FlightRequest request) {
        Flight flight = new Flight();
        flight.setId(request.getId());
        repository.save(flight);
    }

    // UPDATE
    public void update(Long id, FlightRequest request) {
        Flight flight = getEntityObjectById(id);
        flight.setId(request.getId());
        repository.save(flight);
    }

    // DELETE ONE
    public void delete(Long id) {
        Flight flight = getEntityObjectById(id);
        if (flight.getAircraftInstances().isEmpty()) {
            repository.delete(flight);
        } else {
            throw new WrongInputDataException("Flight with id " + id + " has some instances.");
        }
    }

    private Flight getEntityObjectById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Can't find flight with id " + id));
    }
}