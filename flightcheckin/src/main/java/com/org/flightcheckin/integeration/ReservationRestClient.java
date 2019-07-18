package com.org.flightcheckin.integeration;

import com.org.flightcheckin.integeration.dto.Reservation;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);

	public Reservation updateReservation(ReservationUpdateRequest request);
}
