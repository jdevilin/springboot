package com.org.flightreservation.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.flightreservation.entity.Flight;
import com.org.flightreservation.repository.FlightRepository;

@Controller
public class FlightController {

	@Autowired
	FlightRepository flightRepository;

	@RequestMapping("/findFlighs")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat  (pattern = "MM-dd-yyyy") Date departureDate, ModelMap model) {
		List<Flight> flights = flightRepository.findFlights(from, to,departureDate);
		model.addAttribute("flights", flights);		
		return "displayFights";
	}
}
