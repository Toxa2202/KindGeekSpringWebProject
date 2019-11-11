package com.saint.anthony.ryanairspringweb.service;

import com.saint.anthony.ryanairspringweb.dto.request.AircraftSeatRequest;
import com.saint.anthony.ryanairspringweb.dto.request.AirportRequest;
import com.saint.anthony.ryanairspringweb.dto.response.AircraftSeatResponse;
import com.saint.anthony.ryanairspringweb.dto.response.AirportResponse;
import com.saint.anthony.ryanairspringweb.entity.AircraftSeat;
import com.saint.anthony.ryanairspringweb.entity.Airport;
import com.saint.anthony.ryanairspringweb.exceptions.WrongInputDataException;
import com.saint.anthony.ryanairspringweb.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AirportService {
    @Autowired
    private AirportRepository repository;

    // GET ALL
    public List<AirportResponse> getAirports() {
        return repository.findAll()
                .stream()
                .map(AirportResponse::new)
                .collect(Collectors.toList());
    }

    // GET ONE
    public AirportResponse getById(String id) {
        Optional<Airport> airportOptional = repository.findById(id);
        return new AirportResponse(getEntityObjectById(id));
    }

    // SAVE
    public void save(AirportRequest request) {
        Airport airport = new Airport();
        airport.setIataAirportCode(request.getIataAirportCode());
        repository.save(airport);
    }

    // UPDATE
    public void update(String id, AirportRequest request) {
        Airport airport = getEntityObjectById(id);
        airport.setIataAirportCode(request.getIataAirportCode());
        repository.save(airport);
    }

    // DELETE ONE
    public void delete(String id) {
        Airport airport = getEntityObjectById(id);
        if (airport.getDepartures().isEmpty()) {
            repository.delete(airport);
        } else {
            throw new WrongInputDataException("Airport with id " + id + " has some instances.");
        }
    }

    private Airport getEntityObjectById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Can't find airport with id " + id));
    }
}
