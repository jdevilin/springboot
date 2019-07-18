package com.org.flightreservation.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.flightreservation.dto.ReservationRequest;
import com.org.flightreservation.entity.Flight;
import com.org.flightreservation.entity.Passenger;
import com.org.flightreservation.entity.Reservation;
import com.org.flightreservation.repository.FlightRepository;
import com.org.flightreservation.repository.PassengerRepository;
import com.org.flightreservation.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public Reservation bookFlight(ReservationRequest request) {

		// Make Payment

		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());

		Passenger savePassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savePassenger);
		reservation.setCheckedIn(false);

		Reservation savedreservation =reservationRepository.save(reservation);
	

		return savedreservation;
	}

}
