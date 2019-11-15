package com.saint.anthony.ryanairspringweb.service;

import com.saint.anthony.ryanairspringweb.dto.request.AircraftInstanceRequest;
import com.saint.anthony.ryanairspringweb.dto.response.AircraftInstanceResponse;
import com.saint.anthony.ryanairspringweb.dto.response.DataResponse;
import com.saint.anthony.ryanairspringweb.entity.AircraftInstance;
import com.saint.anthony.ryanairspringweb.exceptions.WrongInputDataException;
import com.saint.anthony.ryanairspringweb.repository.AircraftInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AircraftInstanceService {
    @Autowired
    private AircraftInstanceRepository repository;

    // GET ALL
//    public List<AircraftInstanceResponse> getAircraftInstances() {
//        return repository.findAll()
//                .stream()
//                .map(AircraftInstanceResponse::new)
//                .collect(Collectors.toList());
//    }

    // GET ALL
    public DataResponse<AircraftInstanceResponse> getAircraftInstances(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<AircraftInstance> aircraftInstancePage = repository.findAll(pageRequest);

        return new DataResponse<>(aircraftInstancePage.getContent().stream().map(AircraftInstanceResponse::new)
                .collect(Collectors.toList()), aircraftInstancePage);
    }

    // GET ONE
    public AircraftInstanceResponse getById(Long id) {
        Optional<AircraftInstance> aircraftInstanceOptional = repository.findById(id);
        return new AircraftInstanceResponse(getEntityObjectById(id));
    }

    // SAVE
//    public void save(AircraftInstanceRequest request) {
//        AircraftInstance aircraftInstance = new AircraftInstance();
//        aircraftInstance.setAircraftInstanceId(request.getAircraftInstanceId());
//        repository.save(aircraftInstance);
//    }

    // UPDATE
//    public void update(Long id, AircraftInstanceRequest request) {
//        AircraftInstance aircraftInstance = getEntityObjectById(id);
//        aircraftInstance.setAircraftInstanceId(request.getAircraftInstanceId());
//        repository.save(aircraftInstance);
//    }

    // DELETE ONE
//    public void delete(Long id) {
//        AircraftInstance aircraftInstance = getEntityObjectById(id);
//        if (aircraftInstance.getAircraft() == null) {
//            repository.delete(aircraftInstance);
//        } else {
//            throw new WrongInputDataException("AircraftInstance with id " + id + " has some instances.");
//        }
//    }

    private AircraftInstance getEntityObjectById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Can't find aircraftInstance with id " + id));
    }
}
