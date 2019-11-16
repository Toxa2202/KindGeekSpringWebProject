package com.saint.anthony.ryanairspringweb.controller;

import com.saint.anthony.ryanairspringweb.dto.response.AircraftInstanceResponse;
import com.saint.anthony.ryanairspringweb.dto.response.DataResponse;
import com.saint.anthony.ryanairspringweb.service.AircraftInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/aircraftInstance")
public class AircraftInstanceController {
    @Autowired
    private AircraftInstanceService service;

    // GET ALL
    @GetMapping
    public DataResponse<AircraftInstanceResponse> getAll(@RequestParam Integer page,
                                                         @RequestParam Integer size) {
        return service.getAircraftInstances(page, size);
    }

    @GetMapping("/{id}")
    public AircraftInstanceResponse getAircraftInstance(@PathVariable Long id) {
        return service.getById(id);
    }

}
