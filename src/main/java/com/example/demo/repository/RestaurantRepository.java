package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Restaurant;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer>{
	public Restaurant findByRestaurantName(String restaurantName);
	
}
