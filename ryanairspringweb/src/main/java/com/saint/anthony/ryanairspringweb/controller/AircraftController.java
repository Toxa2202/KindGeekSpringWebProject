package com.saint.anthony.ryanairspringweb.controller;

import com.saint.anthony.ryanairspringweb.dto.request.AircraftRequest;
import com.saint.anthony.ryanairspringweb.dto.response.AircraftResponse;
import com.saint.anthony.ryanairspringweb.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/aircraft")
public class AircraftController {
    @Autowired
    private AircraftService service;

    @GetMapping // ALL
    public List<AircraftResponse> getAircrafts() {
        return service.getAircrafts();
    }

    @GetMapping("/{id}")
    public AircraftResponse getAircraft(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping // ALL
    public void create(@RequestBody AircraftRequest request) {
        service.save(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody AircraftRequest request) {
        service.update(id, request);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
