package com.org.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.flightreservation.dto.ReservationRequest;
import com.org.flightreservation.entity.Flight;
import com.org.flightreservation.entity.Reservation;
import com.org.flightreservation.repository.FlightRepository;
import com.org.flightreservation.repository.PassengerRepository;
import com.org.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	FlightRepository flightRepository;

	@Autowired
	ReservationService reservationService;
	
	@Autowired
	PassengerRepository passengerRepository;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam Long flightId, ModelMap modelMap) {

		System.out.println("BBBBBBBBBBBBB"+flightId);
		Flight flight = flightRepository.findById(flightId).get();
		//System.out.println(flight);

		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}

	@RequestMapping(value="/completeReservation",method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		System.out.println(request.getPassengerFirstName() +"<<<<<<<<<<<<<<<<<<<<<<");
         System.out.println(">>>>>>>>>>>>>>>>>>>>"+request.getFlightId());
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created sucessfully and the id is" + reservation.getId());
		return "reservationConfirmation";

	}

}
