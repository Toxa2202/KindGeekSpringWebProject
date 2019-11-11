package com.saint.anthony.ryanairspringweb.controller;

import com.saint.anthony.ryanairspringweb.dto.request.TravelClassRequest;
import com.saint.anthony.ryanairspringweb.dto.response.TravelClassResponse;
import com.saint.anthony.ryanairspringweb.service.TravelClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/travelClass")
public class TravelClassController {
    @Autowired
    private TravelClassService travelClassService;

    @GetMapping // ALL
    public List<TravelClassResponse> getTravelClasses() {
        return travelClassService.getTravelClasses();
    }

    @GetMapping("/{id}")
    public TravelClassResponse getTravelClass(@PathVariable Long id) {
        return travelClassService.getById(id);
    }

    @PostMapping // ADD
    public void save(@RequestBody @Valid TravelClassRequest request) {
        travelClassService.save(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody TravelClassRequest request) {
        travelClassService.update(id, request);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        travelClassService.delete(id);
    }
}