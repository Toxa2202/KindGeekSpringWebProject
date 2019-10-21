package com.saint.anthony.ryanairspringweb.controller;

import com.saint.anthony.ryanairspringweb.dto.request.FlightRequest;
import com.saint.anthony.ryanairspringweb.dto.request.FlightSeatPriceRequest;
import com.saint.anthony.ryanairspringweb.dto.response.FlightResponse;
import com.saint.anthony.ryanairspringweb.dto.response.FlightSeatPriceResponse;
import com.saint.anthony.ryanairspringweb.entity.FlightSeatPrice;
import com.saint.anthony.ryanairspringweb.service.FlightSeatPriceService;
import com.saint.anthony.ryanairspringweb.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/flightSeatPrice")
public class FlightSeatPriceController {
    @Autowired
    private FlightSeatPriceService service;

    @GetMapping // ALL
    public List<FlightSeatPriceResponse> getFlightSeatPrices() {
        return service.getFlightSeatPrices();
    }

    @GetMapping("/{id}")
    public FlightSeatPriceResponse getFlight(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping // ALL
    public void create(@RequestBody FlightSeatPriceRequest request) {
        service.save(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody FlightSeatPriceRequest request) {
        service.update(id, request);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
