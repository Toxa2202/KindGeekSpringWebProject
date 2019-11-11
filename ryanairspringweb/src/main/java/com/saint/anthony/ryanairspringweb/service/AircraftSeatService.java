package com.saint.anthony.ryanairspringweb.service;

import com.saint.anthony.ryanairspringweb.dto.request.AircraftSeatRequest;
import com.saint.anthony.ryanairspringweb.dto.response.AircraftSeatResponse;
import com.saint.anthony.ryanairspringweb.entity.AircraftSeat;
import com.saint.anthony.ryanairspringweb.exceptions.WrongInputDataException;
import com.saint.anthony.ryanairspringweb.repository.AircraftSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AircraftSeatService {
    @Autowired
    private AircraftSeatRepository repository;

    // GET ALL
    public List<AircraftSeatResponse> aircraftSeats() {
        return repository.findAll()
                .stream()
                .map(AircraftSeatResponse::new)
                .collect(Collectors.toList());
    }

    // GET ONE
    public AircraftSeatResponse getById(Long id) {
        Optional<AircraftSeat> aircraftSeatOptional = repository.findById(id);
        return new AircraftSeatResponse(getEntityObjectById(id));
    }

    // SAVE --> NOT NEED
//    public void save(AircraftSeatRequest request) {
//        AircraftSeat aircraftSeat = new AircraftSeat();
//        aircraftSeat.setId(request.getSeatId());
//        repository.save(aircraftSeat);
//    }

    // UPDATE --> NOT NEED
//    public void update(Long id, AircraftSeatRequest request) {
//        AircraftSeat aircraftSeat = getEntityObjectById(id);
//        aircraftSeat.setId(request.getSeatId());
//        repository.save(aircraftSeat);
//    }

    // DELETE ONE --> NOT NEED
//    public void delete(Long id) {
//        AircraftSeat aircraftSeat = getEntityObjectById(id);
//        if (aircraftSeat.getAircraft() == null) {
//            repository.delete(aircraftSeat);
//        } else {
//            throw new WrongInputDataException("AircraftSeat with id " + id + " has some instances.");
//        }
//    }

    private AircraftSeat getEntityObjectById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Can't find aircraftSeat with id " + id));
    }

}