package com.saint.anthony.ryanairspringweb.controller;

import com.saint.anthony.ryanairspringweb.dto.request.AircraftRequest;
import com.saint.anthony.ryanairspringweb.dto.request.ClientRequest;
import com.saint.anthony.ryanairspringweb.dto.response.AircraftResponse;
import com.saint.anthony.ryanairspringweb.dto.response.ClientResponse;
import com.saint.anthony.ryanairspringweb.service.AircraftService;
import com.saint.anthony.ryanairspringweb.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping // ALL
    public List<ClientResponse> getClients() {
        return service.getClients();
    }

    @GetMapping("/{id}")
    public ClientResponse getClient(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping // ALL
    public void create(@RequestBody ClientRequest request) {
        service.save(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ClientRequest request) {
        service.update(id, request);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
