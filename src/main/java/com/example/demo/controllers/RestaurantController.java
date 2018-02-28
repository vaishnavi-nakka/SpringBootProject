package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.demo.domain.Restaurant;
import com.example.demo.service.RestaurantService;
import com.example.demo.service.RestaurantServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class RestaurantController {

	RestaurantService restaurantService;

	@Autowired
	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@PostMapping("/restaurant") 
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant){
		Restaurant addedRestaurant= restaurantService.addRestaurant(restaurant);
		return new ResponseEntity<Restaurant> (addedRestaurant, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/restaurant/{restaurantId}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable int restaurantId){
		String message= ((RestaurantServiceImpl) restaurantService).deleteRestaurant(restaurantId);
		return new ResponseEntity<String> (message, HttpStatus.OK);
	}
	
	@GetMapping("/restaurant/{id}")
	public ResponseEntity<Restaurant> searchById(@PathVariable("id") int restaurantId){
		Restaurant addedRestaurant= ((RestaurantServiceImpl) restaurantService).searchById(restaurantId);
		return new ResponseEntity<Restaurant> (addedRestaurant, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/restaurant") 
	public ResponseEntity<List<Restaurant>> findAll(){
		List<Restaurant> restaurants = restaurantService.findAll();
		return new ResponseEntity<List<Restaurant>> (restaurants, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/restaurant", params="name")
	public ResponseEntity<Restaurant> findByRestaurantName(@RequestParam("name") String restaurantName){
		Restaurant restaurantByName = ((RestaurantServiceImpl) restaurantService).searchByRestaurantName(restaurantName);
		return new ResponseEntity<Restaurant> (restaurantByName, HttpStatus.OK);
	}
	
}
