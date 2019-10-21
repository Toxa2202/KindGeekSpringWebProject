package com.saint.anthony.ryanairspringweb.service;

import com.saint.anthony.ryanairspringweb.dto.request.TravelClassRequest;
import com.saint.anthony.ryanairspringweb.dto.response.TravelClassResponse;
import com.saint.anthony.ryanairspringweb.entity.TravelClass;
import com.saint.anthony.ryanairspringweb.exceptions.WrongInputDataException;
import com.saint.anthony.ryanairspringweb.repository.TravelClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TravelClassService {
    @Autowired
    private TravelClassRepository repository;

    // GET ALL
    public List<TravelClassResponse> getTravelClasses() {
        return repository.findAll()
                .stream()
                .map(TravelClassResponse::new)
                .collect(Collectors.toList());
    }

    // GET ONE
    public TravelClassResponse getById(Long id) {
        Optional<TravelClass> travelClassOptional = repository.findById(id);
        return new TravelClassResponse(getEntityObjectById(id));
    }

    // SAVE
    public void save(TravelClassRequest request) {
        TravelClass travelClass = new TravelClass();
        travelClass.setId(request.getId());
        repository.save(travelClass);
    }

    // UPDATE
    public void update(Long id, TravelClassRequest request) {
        TravelClass travelClass = getEntityObjectById(id);
        travelClass.setId(request.getId());
        repository.save(travelClass);
    }

    // DELETE ONE
    public void delete(Long id) {
        TravelClass travelClass = getEntityObjectById(id);
        if (travelClass.getAircraftSeats().isEmpty()) {
            repository.delete(travelClass);
        } else {
            throw new WrongInputDataException("TravelClass with id " + id + " has some instances.");
        }
    }

    private TravelClass getEntityObjectById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Can't find travelClass with id " + id));
    }
}
