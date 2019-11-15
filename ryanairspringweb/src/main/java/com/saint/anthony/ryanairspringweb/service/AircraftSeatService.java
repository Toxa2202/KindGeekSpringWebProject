package com.saint.anthony.ryanairspringweb.service;

import com.saint.anthony.ryanairspringweb.dto.request.AircraftSeatRequest;
import com.saint.anthony.ryanairspringweb.dto.response.AircraftSeatResponse;
import com.saint.anthony.ryanairspringweb.dto.response.DataResponse;
import com.saint.anthony.ryanairspringweb.entity.AircraftSeat;
import com.saint.anthony.ryanairspringweb.exceptions.WrongInputDataException;
import com.saint.anthony.ryanairspringweb.repository.AircraftSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AircraftSeatService {
    @Autowired
    private AircraftSeatRepository repository;

    // GET ALL
    public DataResponse<AircraftSeatResponse> getAllAircraftSeats(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<AircraftSeat> aircraftSeatPage = repository.findAll(pageRequest);

        return new DataResponse<>(aircraftSeatPage.getContent().stream().map(AircraftSeatResponse::new)
                .collect(Collectors.toList()), aircraftSeatPage);
    }

    // GET ONE
    public AircraftSeatResponse getById(Long id) {
        Optional<AircraftSeat> aircraftSeatOptional = repository.findById(id);
        return new AircraftSeatResponse(getEntityObjectById(id));
    }

    private AircraftSeat getEntityObjectById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Can't find aircraftSeat with id " + id));
    }

}