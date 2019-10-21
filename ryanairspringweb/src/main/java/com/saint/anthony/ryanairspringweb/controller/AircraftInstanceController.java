package com.saint.anthony.ryanairspringweb.controller;

import com.saint.anthony.ryanairspringweb.dto.request.AircraftInstanceRequest;
import com.saint.anthony.ryanairspringweb.dto.request.AircraftRequest;
import com.saint.anthony.ryanairspringweb.dto.response.AircraftInstanceResponse;
import com.saint.anthony.ryanairspringweb.dto.response.AircraftResponse;
import com.saint.anthony.ryanairspringweb.service.AircraftInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/aircraftInstance")
public class AircraftInstanceController {
    @Autowired
    private AircraftInstanceService service;

    @GetMapping // ALL
    public List<AircraftInstanceResponse> getAircraftInstances() {
        return service.getAircraftInstances();
    }

    @GetMapping("/{id}")
    public AircraftInstanceResponse getAircraftInstance(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping // ALL
    public void create(@RequestBody AircraftInstanceRequest request) {
        service.save(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody AircraftInstanceRequest request) {
        service.update(id, request);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
