package com.saint.anthony.ryanairspringweb.controller;

import com.saint.anthony.ryanairspringweb.dto.request.AircraftRequest;
import com.saint.anthony.ryanairspringweb.dto.request.TravelClassRequest;
import com.saint.anthony.ryanairspringweb.dto.response.AircraftResponse;
import com.saint.anthony.ryanairspringweb.dto.response.TravelClassResponse;
import com.saint.anthony.ryanairspringweb.service.AircraftService;
import com.saint.anthony.ryanairspringweb.service.TravelClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/travelClass")
public class TravelClassController {
    @Autowired
    private TravelClassService service;

    @GetMapping // ALL
    public List<TravelClassResponse> getTravelClasses() {
        return service.getTravelClasses();
    }

    @GetMapping("/{id}")
    public TravelClassResponse getTravelClass(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping // ALL
    public void create(@RequestBody TravelClassRequest request) {
        service.save(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody TravelClassRequest request) {
        service.update(id, request);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}