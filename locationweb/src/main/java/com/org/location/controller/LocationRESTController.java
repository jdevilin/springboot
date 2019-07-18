package com.org.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.location.entites.Location;
import com.org.location.repos.LocationRepository;

@RestController
@RequestMapping("/locatios")
public class LocationRESTController {

	@Autowired
	LocationRepository locationRepository;

	@GetMapping
	public List<Location> getLocation() {
		return locationRepository.findAll();
	}

	@PostMapping
	public Location createLocation(@RequestBody Location location) {
		return locationRepository.save(location);
	}

	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		return locationRepository.save(location);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(int id) {
		locationRepository.deleteById(id);
	}

}
