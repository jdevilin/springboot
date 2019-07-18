package com.org.flightreservation.services;

import com.org.flightreservation.dto.ReservationRequest;
import com.org.flightreservation.entity.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
