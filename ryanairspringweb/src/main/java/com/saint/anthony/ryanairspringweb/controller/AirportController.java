package com.saint.anthony.ryanairspringweb.controller;

import com.saint.anthony.ryanairspringweb.dto.request.AircraftRequest;
import com.saint.anthony.ryanairspringweb.dto.request.AirportRequest;
import com.saint.anthony.ryanairspringweb.dto.response.AircraftResponse;
import com.saint.anthony.ryanairspringweb.dto.response.AirportResponse;
import com.saint.anthony.ryanairspringweb.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/airport")
public class AirportController {
    @Autowired
    private AirportService service;

    @GetMapping // ALL
    public List<AirportResponse> getAirports() {
        return service.getAirports();
    }

    @GetMapping("/{id}")
    public AirportResponse getAirport(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping // ALL
    public void create(@RequestBody AirportRequest request) {
        service.save(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody AirportRequest request) {
        service.update(id, request);
    }

    @DeleteMapping
    public void delete(@RequestParam String id) {
        service.delete(id);
    }
}
