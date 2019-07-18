package com.org.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.flightreservation.entity.Passenger;


public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
