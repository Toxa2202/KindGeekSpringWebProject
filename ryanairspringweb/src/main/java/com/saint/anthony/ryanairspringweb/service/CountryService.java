package com.saint.anthony.ryanairspringweb.service;

import com.saint.anthony.ryanairspringweb.dto.request.CountryRequest;
import com.saint.anthony.ryanairspringweb.dto.response.CountryResponse;
import com.saint.anthony.ryanairspringweb.entity.Country;
import com.saint.anthony.ryanairspringweb.exceptions.WrongInputDataException;
import com.saint.anthony.ryanairspringweb.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryService {
    @Autowired
    private CountryRepository repository;

    // GET ALL
    public List<CountryResponse> countries() {
        return repository.findAll()
                .stream()
                .map(CountryResponse::new)
                .collect(Collectors.toList());
    }

    // GET ONE
    public CountryResponse getById(String iataCountryCode) {
        Optional<Country> countryOptional = repository.findById(iataCountryCode);
        return new CountryResponse(getEntityObjectById(iataCountryCode));
    }

    // SAVE
    public void save(CountryRequest request) {
        Country country = new Country();
        country.setIataCountryCode(request.getIataCountryCode());
        repository.save(country);
    }

    // UPDATE
    public void update(String iataCountryCode, CountryRequest request) {
        Country country = getEntityObjectById(iataCountryCode);
        country.setIataCountryCode(request.getIataCountryCode());
        repository.save(country);
    }

    // DELETE ONE
    public void delete(String iataCountryCode) {
        Country country = getEntityObjectById(iataCountryCode);
        if (country.getAirports().isEmpty()) {
            repository.delete(country);
        } else {
            throw new WrongInputDataException("Country with IATA " + iataCountryCode + " has some instances.");
        }
    }

    private Country getEntityObjectById(String iataCountryCode) {
        return repository.findById(iataCountryCode)
                .orElseThrow(() -> new WrongInputDataException("Can't find country with IATA " + iataCountryCode));
    }
}
