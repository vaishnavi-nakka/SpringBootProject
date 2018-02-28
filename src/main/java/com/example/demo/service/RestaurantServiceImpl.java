package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Restaurant;
import com.example.demo.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	
	RestaurantRepository restaurantRepository;
	

	@Autowired
	public void setRestaurantRepository(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	public Restaurant addRestaurant(Restaurant restaurant){
		restaurantRepository.save(restaurant);
		return restaurant;
	}
	
	public String deleteRestaurant(int restaurantId){
		restaurantRepository.delete(restaurantId);
		return "Restaurant deleted";
	}
	
	public Restaurant searchById(int restaurantId){
		return restaurantRepository.findOne(restaurantId);
		
	}
	
	public List<Restaurant> findAll(){
		return (List<Restaurant>) restaurantRepository.findAll();
	}
	
	public Restaurant searchByRestaurantName(String restaurantName){
		return restaurantRepository.findByRestaurantName(restaurantName);
	}
	
}
