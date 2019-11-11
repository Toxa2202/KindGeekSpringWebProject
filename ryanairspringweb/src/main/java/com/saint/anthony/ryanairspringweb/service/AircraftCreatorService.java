package com.saint.anthony.ryanairspringweb.service;

import com.saint.anthony.ryanairspringweb.dto.response.DataResponse;
import com.saint.anthony.ryanairspringweb.entity.Aircraft;
import com.saint.anthony.ryanairspringweb.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @Autowired
    private AircraftRepository aircraftRepository;

    // GET ALL
    public List<AircraftCreatorResponse> getAircraftCreators() {
        return aircraftCreatorRepository.findAll()
                .stream()
                .map(AircraftCreatorResponse::new)
                .collect(Collectors.toList());
    }

    // GET ALL PAGEABLE
    public DataResponse<AircraftCreatorResponse> getAllAircraftCreators(Integer page, Integer size,
                                                                        String sortBy, Sort.Direction direction,
                                                                        String name) {
        Sort sort = Sort.by(direction, sortBy);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<AircraftCreator> aircraftCreatorPage;
        if (name != null) {
            aircraftCreatorPage = aircraftCreatorRepository.findAllByNameLike("%" + name + "%", pageRequest);
        } else {
            aircraftCreatorPage = aircraftCreatorRepository.findAll(pageRequest);
        }
        return new DataResponse<>(aircraftCreatorPage.getContent().stream()
                .map(AircraftCreatorResponse::new).collect(Collectors.toList()), aircraftCreatorPage);
    }

    // GET ONE
    public AircraftCreatorResponse getById(Long id) {
        return new AircraftCreatorResponse(getEntityObjectById(id));
    }

    // SAVE
    public AircraftCreatorResponse save(AircraftCreatorRequest aircraftCreatorRequest) {
        AircraftCreator aircraftCreator = new AircraftCreator();
        aircraftCreator.setName(aircraftCreatorRequest.getName());
        return new AircraftCreatorResponse(aircraftCreatorRepository.save(aircraftCreator));
    }

    // UPDATE
    public void update(Long id, AircraftCreatorRequest aircraftCreatorRequest) {
        AircraftCreator aircraftCreator = getEntityObjectById(id);
        aircraftCreator.setName(aircraftCreatorRequest.getName());
        aircraftCreatorRepository.save(aircraftCreator);
    }

    // DELETE ONE
    public boolean delete(Long id) {
        AircraftCreator aircraftCreator = getEntityObjectById(id);
        if (aircraftCreator.getAircrafts().isEmpty()) {
            aircraftCreatorRepository.delete(aircraftCreator);
            return true;
        } else {
            throw new WrongInputDataException("AircraftCreator with id " + id + " has some aircrafts.");
        }
    }

    private AircraftCreator getEntityObjectById(Long id) {
        return aircraftCreatorRepository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Can not find aircraft creator with id " + id + " not found."));
    }
}
