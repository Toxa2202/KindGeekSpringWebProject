package com.saint.anthony.ryanairspringweb.service;

import com.saint.anthony.ryanairspringweb.dto.request.DirectionRequest;
import com.saint.anthony.ryanairspringweb.dto.response.DirectionResponse;
import com.saint.anthony.ryanairspringweb.entity.Direction;
import com.saint.anthony.ryanairspringweb.exceptions.WrongInputDataException;
import com.saint.anthony.ryanairspringweb.repository.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DirectionService {
    @Autowired
    private DirectionRepository repository;

    // GET ALL
    public List<DirectionResponse> getDirections() {
        return repository.findAll()
                .stream()
                .map(DirectionResponse::new)
                .collect(Collectors.toList());
    }

    // GET ONE
    public DirectionResponse getById(Long id) {
        Optional<Direction> directionOptional = repository.findById(id);
        return new DirectionResponse(getEntityObjectById(id));
    }

    // SAVE
    public void save(DirectionRequest request) {
        Direction direction = new Direction();
        direction.setId(request.getId());
        repository.save(direction);
    }

    // UPDATE
    public void update(Long id, DirectionRequest request) {
        Direction direction = getEntityObjectById(id);
        direction.setId(request.getId());
        repository.save(direction);
    }

    // DELETE ONE
    public void delete(Long id) {
        Direction direction = getEntityObjectById(id);
        if (direction.getSchedules().isEmpty()) {
            repository.delete(direction);
        } else {
            throw new WrongInputDataException("Direction with id " + id + " has some instances.");
        }
    }

    private Direction getEntityObjectById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Can't find direction with id " + id));
    }
}
