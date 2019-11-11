package com.saint.anthony.ryanairspringweb.controller;

import com.saint.anthony.ryanairspringweb.dto.request.AircraftCreatorRequest;
import com.saint.anthony.ryanairspringweb.dto.response.AircraftCreatorResponse;
import com.saint.anthony.ryanairspringweb.dto.response.DataResponse;
import com.saint.anthony.ryanairspringweb.service.AircraftCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/aircraftCreator")
public class AircraftCreatorController {
    @Autowired
    private AircraftCreatorService airCreatorService;

    // GET ALL
//    @GetMapping
//    public DataResponse<AircraftCreatorResponse> getAll(@RequestParam Integer page,
//                                                        @RequestParam Integer size,
//                                                        @RequestParam String sortBy,
//                                                        @RequestParam Sort.Direction direction,
//                                                        @RequestParam(required = false) String name) {
//        return airCreatorService.getAllAircraftCreators(page, size, sortBy, direction, name);
//    }

    // GET ALL
    @GetMapping
    public List<AircraftCreatorResponse> getAll() {
        return airCreatorService.getAircraftCreators();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public AircraftCreatorResponse getById(@PathVariable Long id) {
        return airCreatorService.getById(id);
    }

    // SAVE
    @PostMapping
    public AircraftCreatorResponse save(@RequestBody @Valid AircraftCreatorRequest request) {
        return airCreatorService.save(request);
    }

    // UPDATE
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody AircraftCreatorRequest request) {
        airCreatorService.update(id, request);
    }

    // DELETE
    @DeleteMapping
    public boolean delete(@RequestParam Long id) {
        return airCreatorService.delete(id);
    }
}

// ще 6 занять від 21.10.2019 !!!