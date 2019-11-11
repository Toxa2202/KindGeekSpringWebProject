package com.saint.anthony.ryanairspringweb.service;

import com.saint.anthony.ryanairspringweb.dto.request.FlightSeatPriceRequest;
import com.saint.anthony.ryanairspringweb.dto.response.FlightSeatPriceResponse;
import com.saint.anthony.ryanairspringweb.entity.FlightSeatPrice;
import com.saint.anthony.ryanairspringweb.exceptions.WrongInputDataException;
import com.saint.anthony.ryanairspringweb.repository.FlightSeatPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightSeatPriceService {
    @Autowired
    private FlightSeatPriceRepository repository;

    // GET ALL
    public List<FlightSeatPriceResponse> getFlightSeatPrices() {
        return repository.findAll()
                .stream()
                .map(FlightSeatPriceResponse::new)
                .collect(Collectors.toList());
    }

    // GET ONE
    public FlightSeatPriceResponse getById(Long id) {
        Optional<FlightSeatPrice> flightSeatPriceOptional = repository.findById(id);
        return new FlightSeatPriceResponse(getEntityObjectById(id));
    }

    // SAVE
    public void save(FlightSeatPriceRequest request) {
        FlightSeatPrice flightSeatPrice = new FlightSeatPrice();
        flightSeatPrice.setSeatId(request.getSeatId());
        repository.save(flightSeatPrice);
    }

    // UPDATE
    public void update(Long id, FlightSeatPriceRequest request) {
        FlightSeatPrice flightSeatPrice = getEntityObjectById(id);
        flightSeatPrice.setSeatId(request.getSeatId());
        repository.save(flightSeatPrice);
    }

    // DELETE ONE
    public void delete(Long id) {
        FlightSeatPrice flightSeatPrice = getEntityObjectById(id);
        if (flightSeatPrice.getSeatIds().isEmpty()) {
            repository.delete(flightSeatPrice);
        } else {
            throw new WrongInputDataException("FlightSeatPrice with id " + id + " has some instances.");
        }
    }

    private FlightSeatPrice getEntityObjectById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Can't find flightSeatPrice with id " + id));
    }
}
