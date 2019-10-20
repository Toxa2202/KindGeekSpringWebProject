package com.saint.anthony.ryanairspringweb.repository;

import com.saint.anthony.ryanairspringweb.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
