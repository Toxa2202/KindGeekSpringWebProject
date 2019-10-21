package com.saint.anthony.ryanairspringweb.service;

import com.saint.anthony.ryanairspringweb.dto.request.ScheduleRequest;
import com.saint.anthony.ryanairspringweb.dto.response.ScheduleResponse;
import com.saint.anthony.ryanairspringweb.entity.Schedule;
import com.saint.anthony.ryanairspringweb.exceptions.WrongInputDataException;
import com.saint.anthony.ryanairspringweb.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository repository;

    // GET ALL
    public List<ScheduleResponse> getSchedules() {
        return repository.findAll()
                .stream()
                .map(ScheduleResponse::new)
                .collect(Collectors.toList());
    }

    // GET ONE
    public ScheduleResponse getById(Long id) {
        Optional<Schedule> scheduleOptional = repository.findById(id);
        return new ScheduleResponse(getEntityObjectById(id));
    }

    // SAVE
    public void save(ScheduleRequest request) {
        Schedule schedule = new Schedule();
        schedule.setId(request.getId());
        repository.save(schedule);
    }

    // UPDATE
    public void update(Long id, ScheduleRequest request) {
        Schedule schedule = getEntityObjectById(id);
        schedule.setId(request.getId());
        repository.save(schedule);
    }

    // DELETE ONE
    public void delete(Long id) {
        Schedule schedule = getEntityObjectById(id);
        if (schedule.getFlights().isEmpty()) {
            repository.delete(schedule);
        } else {
            throw new WrongInputDataException("Schedule with id " + id + " has some instances.");
        }
    }

    private Schedule getEntityObjectById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Can't find schedule with id " + id));
    }
}
