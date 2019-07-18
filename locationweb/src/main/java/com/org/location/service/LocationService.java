package com.org.location.service;

import java.util.List;

import com.org.location.entites.Location;

public interface LocationService {

	Location createLocation(Location location);

	Location updateLocation(Location location);

	void deleteLocation(Location location);

	Location getLoation(int id);

	List<Location> getAllLocation();

}
