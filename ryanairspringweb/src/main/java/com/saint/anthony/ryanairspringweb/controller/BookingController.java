package com.saint.anthony.ryanairspringweb.controller;

import com.saint.anthony.ryanairspringweb.dto.request.AircraftRequest;
import com.saint.anthony.ryanairspringweb.dto.request.BookingRequest;
import com.saint.anthony.ryanairspringweb.dto.response.AircraftResponse;
import com.saint.anthony.ryanairspringweb.dto.response.BookingResponse;
import com.saint.anthony.ryanairspringweb.service.AircraftService;
import com.saint.anthony.ryanairspringweb.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService service;

    @GetMapping // ALL
    public List<BookingResponse> getBookings() {
        return service.getBookings();
    }

    @GetMapping("/{id}")
    public BookingResponse getBooking(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping // ALL
    public void create(@RequestBody BookingRequest request) {
        service.save(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody BookingRequest request) {
        service.update(id, request);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}