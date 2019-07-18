package com.org.flightreservation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.flightreservation.entity.Flight;



public interface FlightRepository extends JpaRepository<Flight,Long> {
     @Query("from Flight where depatureCity=:depatureCity and arrivalCity=:arrivalCity and dateOfDepature=:dateOfDepature ")
	 List<Flight> findFlights(@Param("depatureCity") String form,@Param("arrivalCity") String to,@Param("dateOfDepature")  Date departureDate);
}
