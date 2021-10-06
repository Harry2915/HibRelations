package com.mysecondapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysecondapp.model.Location;
import com.mysecondapp.model.User;
import com.mysecondapp.services.LocationServices;

@RestController
public class LocationController {

	@Autowired
	private LocationServices locationService;

	@GetMapping("/locations")
	public List<Location> getAllLocations() {
		return locationService.findAll();
	}

	@GetMapping("/locations/{id}")
	public Optional<Location> getLocationById(@PathVariable Integer id) {
		return locationService.findById(id);
	}
	
	@GetMapping("/locations/{id}/users")  /////takes the location_id and returns the users in that location.
	public List<User> getUsersById(@PathVariable Integer id) {
		Optional<Location> location = locationService.findById(id);
		if( location.isPresent())
			return location.get().getUsers();
		
		return null;
	}
	
	@PostMapping("/addlocation")
	public void addNewLocation(@RequestBody Location location) {
		locationService.addLocation(location);
	}
	
	@PutMapping("/updateLocation")
	public void updateLocation(@RequestBody Location location) {
		locationService.updateLocation(location);
	}
	
	@DeleteMapping("/deleteLocation/{id}")
	public void deleteLocation(@PathVariable Integer id) {
		locationService.deleteLocation(id);
		
	}
}
