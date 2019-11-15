package com.saint.anthony.ryanairspringweb.controller;

import com.saint.anthony.ryanairspringweb.dto.response.AircraftSeatResponse;
import com.saint.anthony.ryanairspringweb.dto.response.DataResponse;
import com.saint.anthony.ryanairspringweb.service.AircraftSeatService;
import com.saint.anthony.ryanairspringweb.service.TravelClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/aircraftSeat")
public class AircraftSeatController {
    @Autowired
    private AircraftSeatService  service;

    @Autowired
    private TravelClassService travelClassService;

    // GET ALL
    @GetMapping
    public DataResponse<AircraftSeatResponse> getAll(@RequestParam Integer page,
                                                     @RequestParam Integer size) {
        return service.getAllAircraftSeats(page, size);
    }

    @GetMapping("/{id}")
    public AircraftSeatResponse getAircraftSeat(@PathVariable Long id) {
        return service.getById(id);
    }

//    @PostMapping // ALL
//    public void create(@RequestBody AircraftSeatRequest request) {
//        service.save(request);
//    }

//    @PutMapping("/{id}")
//    public void update(@PathVariable Long id, @RequestBody AircraftSeatRequest request) {
//        service.update(id, request);
//    }
//
//    @DeleteMapping
//    public void delete(@RequestParam Long id) {
//        service.delete(id);
//    }
}
