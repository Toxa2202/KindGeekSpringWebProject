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

    @GetMapping // GET ALL
    public List<AircraftResponse> getAircrafts() {
        return service.getAircrafts();
    }

    @GetMapping("/{id}") // GET BY ID
    public AircraftResponse getAircraft(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping // ADD NEW
    public void save(@RequestBody AircraftRequest request) {
        service.save(request);
    }

    @PutMapping("/{id}") // UPDATE BY ID
    public void update(@PathVariable Long id, @RequestBody AircraftRequest request) {
        service.update(id, request);
    }

    @DeleteMapping // DELETE BY ID
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
