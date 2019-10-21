package com.saint.anthony.ryanairspringweb.controller;

import com.saint.anthony.ryanairspringweb.dto.request.AircraftRequest;
import com.saint.anthony.ryanairspringweb.dto.request.CountryRequest;
import com.saint.anthony.ryanairspringweb.dto.response.AircraftResponse;
import com.saint.anthony.ryanairspringweb.dto.response.CountryResponse;
import com.saint.anthony.ryanairspringweb.service.AircraftService;
import com.saint.anthony.ryanairspringweb.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService service;

    @GetMapping // ALL
    public List<CountryResponse> getCountries() {
        return service.getCountries();
    }

    @GetMapping("/{id}")
    public CountryResponse getCountry(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping // ALL
    public void create(@RequestBody CountryRequest request) {
        service.save(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody CountryRequest request) {
        service.update(id, request);
    }

    @DeleteMapping
    public void delete(@RequestParam String id) {
        service.delete(id);
    }
}
