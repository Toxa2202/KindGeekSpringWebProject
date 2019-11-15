package com.saint.anthony.ryanairspringweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataController {

    @GetMapping("/aircrafts")
    public String getAllAircrafts() {
        return "data/aircraftTable";
    }

    @GetMapping("/airports")
    public String getAllAirports() {
        return "data/airportTable";
    }

    @GetMapping("/bookings")
    public String getAllBookings() {
        return "data/bookingTable";
    }

    @GetMapping("/clients")
    public String getAllClients() {
        return "data/clientTable";
    }

    @GetMapping("/directions")
    public String getAllDirections() {
        return "data/directionTable";
    }

    @GetMapping("/flightStatuses")
    public String getAllFlightStatuses() {
        return "data/flightStatusTable";
    }

    @GetMapping("/schedules")
    public String getAllSchedules() {
        return "data/scheduleTable";
    }

    @GetMapping("/flightSeatPrices")
    public String getAllFlightSeatPrices() {
        return "data/flightSeatPriceTable";
    }
}
