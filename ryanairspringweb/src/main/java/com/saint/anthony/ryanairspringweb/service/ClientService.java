package com.saint.anthony.ryanairspringweb.service;

import com.saint.anthony.ryanairspringweb.dto.request.ClientRequest;
import com.saint.anthony.ryanairspringweb.dto.response.ClientResponse;
import com.saint.anthony.ryanairspringweb.entity.Client;
import com.saint.anthony.ryanairspringweb.exceptions.WrongInputDataException;
import com.saint.anthony.ryanairspringweb.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    // GET ALL
    public List<ClientResponse> getClients() {
        return repository.findAll()
                .stream()
                .map(ClientResponse::new)
                .collect(Collectors.toList());
    }

    // GET ONE
    public ClientResponse getById(Long id) {
        Optional<Client> clientOptional = repository.findById(id);
        return new ClientResponse(getEntityObjectById(id));
    }

    // SAVE
    public void save(ClientRequest request) {
        Client client = new Client();
        client.setId(request.getId());
        repository.save(client);
    }

    // UPDATE
    public void update(Long id, ClientRequest request) {
        Client client = getEntityObjectById(id);
        client.setId(request.getId());
        repository.save(client);
    }

    // DELETE ONE
    public void delete(Long id) {
        Client client = getEntityObjectById(id);
        if (client.getBookings().isEmpty()) {
            repository.delete(client);
        } else {
            throw new WrongInputDataException("Client with id " + id + " has some instances.");
        }
    }

    private Client getEntityObjectById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Can't find client with id " + id));
    }
}