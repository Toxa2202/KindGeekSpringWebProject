package com.saint.anthony.ryanairspringweb.service;

import com.saint.anthony.ryanairspringweb.dto.request.BookingRequest;
import com.saint.anthony.ryanairspringweb.dto.response.BookingResponse;
import com.saint.anthony.ryanairspringweb.entity.Booking;
import com.saint.anthony.ryanairspringweb.exceptions.WrongInputDataException;
import com.saint.anthony.ryanairspringweb.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {
    @Autowired
    private BookingRepository repository;

    // GET ALL
    public List<BookingResponse> bookings() {
        return repository.findAll()
                .stream()
                .map(BookingResponse::new)
                .collect(Collectors.toList());
    }

    // GET ONE
    public BookingResponse getById(Long id) {
        Optional<Booking> bookingOptional = repository.findById(id);
        return new BookingResponse(getEntityObjectById(id));
    }

    // SAVE
    public void save(BookingRequest request) {
        Booking booking = new Booking();
        booking.setId(request.getId());
        repository.save(booking);
    }

    // UPDATE
    public void update(Long id, BookingRequest request) {
        Booking booking = getEntityObjectById(id);
        booking.setId(request.getId());
        repository.save(booking);
    }

    // DELETE ONE
    public void delete(Long id) {
        Booking booking = getEntityObjectById(id);
        if (booking.getId() == null) {
            repository.delete(booking);
        } else {
            throw new WrongInputDataException("Booking with id " + id + " has some instances.");
        }
    }

    private Booking getEntityObjectById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Can't find booking with id " + id));
    }
}