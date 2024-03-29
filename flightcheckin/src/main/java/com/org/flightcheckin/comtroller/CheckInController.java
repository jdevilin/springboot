package com.org.flightcheckin.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.flightcheckin.integeration.ReservationRestClient;
import com.org.flightcheckin.integeration.ReservationUpdateRequest;
import com.org.flightcheckin.integeration.dto.Reservation;

@Controller
public class CheckInController {

	@Autowired
	ReservationRestClient restClient;

	@RequestMapping("/showStartCheckIn")
	public String showStartCheckIn() {

		return "startCheckIn";
	}

	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap modelmap) {
		Reservation reservation = restClient.findReservation(reservationId);
		modelmap.addAttribute("reservation", reservation);
		return "dispalyReservationDetails";
	}

	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId,@RequestParam("numberOfBags") int numberOfBags) {
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setNumberOfBags(numberOfBags);
		restClient.updateReservation(reservationUpdateRequest);
		return "checkInConformation";
	}
}
