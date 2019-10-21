package com.saint.anthony.ryanairspringweb.controller;

import com.saint.anthony.ryanairspringweb.dto.request.AircraftRequest;
import com.saint.anthony.ryanairspringweb.dto.request.FlightStatusRequest;
import com.saint.anthony.ryanairspringweb.dto.response.AircraftResponse;
import com.saint.anthony.ryanairspringweb.dto.response.FlightStatusResponse;
import com.saint.anthony.ryanairspringweb.entity.FlightStatus;
import com.saint.anthony.ryanairspringweb.service.AircraftService;
import com.saint.anthony.ryanairspringweb.service.FlightStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/flightStatus")
public class FlightStatusController {
    @Autowired
    private FlightStatusService service;

    @GetMapping // ALL
    public List<FlightStatusResponse> getFlightStatuses() {
        return service.getFlightStatuses();
    }

    @GetMapping("/{id}")
    public FlightStatusResponse getFlightStatus(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping // ALL
    public void create(@RequestBody FlightStatusRequest request) {
        service.save(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody FlightStatusRequest request) {
        service.update(id, request);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
