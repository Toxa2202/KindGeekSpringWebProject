package com.saint.anthony.ryanairspringweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saint.anthony.ryanairspringweb.dto.request.AircraftCreatorRequest;
import com.saint.anthony.ryanairspringweb.dto.response.AircraftCreatorResponse;
import com.saint.anthony.ryanairspringweb.entity.AircraftCreator;
import com.saint.anthony.ryanairspringweb.exceptions.WrongInputDataException;
import com.saint.anthony.ryanairspringweb.repository.AircraftCreatorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AircraftCreatorService {

    @Autowired
    private AircraftCreatorRepository aircraftCreatorRepository;

    // GET ALL
    public List<AircraftCreatorResponse> getAircraftCreators() {
        return aircraftCreatorRepository.findAll()
                .stream()
                .map(AircraftCreatorResponse::new)
                .collect(Collectors.toList());
    }

    // GET ONE
    public AircraftCreatorResponse getById(Long id) {
        Optional<AircraftCreator> aircraftCreatorOptional = aircraftCreatorRepository.findById(id);
        return new AircraftCreatorResponse(getEntityObjectById(id));
    }

    // SAVE
    public void save(AircraftCreatorRequest aircraftCreatorRequest) {
        AircraftCreator aircraftCreator = new AircraftCreator();
        aircraftCreator.setName(aircraftCreatorRequest.getName());
        aircraftCreatorRepository.save(aircraftCreator);
    }

    // UPDATE
    public void update(Long id, AircraftCreatorRequest aircraftCreatorRequest) {
        AircraftCreator aircraftCreator = getEntityObjectById(id);
        aircraftCreator.setName(aircraftCreatorRequest.getName());
        aircraftCreatorRepository.save(aircraftCreator);
    }

    // DELETE ONE
    public void delete(Long id) {
        AircraftCreator aircraftCreator = getEntityObjectById(id);
        if (aircraftCreator.getAircrafts().isEmpty()) {
            aircraftCreatorRepository.delete(aircraftCreator);
        } else {
            throw new WrongInputDataException("Aircraft creator with id " + id + " has some aircrafts.");
        }
    }

    private AircraftCreator getEntityObjectById(Long id) {
        return aircraftCreatorRepository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Can not find aircraft creator with id " + id));
    }
}
