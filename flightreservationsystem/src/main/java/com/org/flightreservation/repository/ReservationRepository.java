package com.org.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.flightreservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
