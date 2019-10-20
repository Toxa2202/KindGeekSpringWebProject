package com.saint.anthony.ryanairspringweb.controller;

import com.saint.anthony.ryanairspringweb.dto.request.AircraftCreatorRequest;
import com.saint.anthony.ryanairspringweb.dto.response.AircraftCreatorResponse;
import com.saint.anthony.ryanairspringweb.service.AircraftCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/aircraftCreator")
public class AircraftCreatorController {
    @Autowired
    private AircraftCreatorService service;

    @GetMapping // ALL
    public List<AircraftCreatorResponse> getAircraftCreators() {
        return service.getAircraftCreators();
    }

    @GetMapping("/{id}")
    public AircraftCreatorResponse getAircraftCreator(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping // ALL
    public void create(@RequestBody AircraftCreatorRequest request) {
        service.save(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody AircraftCreatorRequest request) {
        service.update(id, request);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
