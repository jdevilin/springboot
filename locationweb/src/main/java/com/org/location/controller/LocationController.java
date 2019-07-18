package com.org.location.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.location.entites.Location;
import com.org.location.repos.LocationRepository;
import com.org.location.service.LocationService;
import com.org.location.util.EmailUtil;
import com.org.location.util.ReportUtil;


@Controller
public class LocationController {
	@Autowired
	LocationService service;

	@Autowired
	LocationRepository repository;

	@Autowired
	EmailUtil emailUtil;

	@Autowired
	ReportUtil reportUtil;

	@Autowired
	ServletContext sc;

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = service.createLocation(location);
		String msg = "Location Saved With Id" + locationSaved.getId();
		modelMap.addAttribute("msg", msg);
		emailUtil.sendEmail("saurabh.softengg@gmail.com", "Hi i am", "Hi i am in factor");
		return "createLocation";
	}

	@RequestMapping("/displayLocations")
	public String dispalyLocation(ModelMap modelMap) {
		System.out.println("I am Here ");
		List<Location> locations = service.getAllLocation();
		System.out.println(locations.size());
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = service.getLoation(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/updateLocation")
	public String showLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = service.getLoation(id);
		System.out.println(location);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}

	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		System.out.println(location);
		service.updateLocation(location);
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/generateReport")
	public String generateReport() {
		String path = sc.getRealPath("/");
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report";

	}

}
