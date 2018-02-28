package com.example.demo.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int restaurantId;
	private String restaurantName;
	private String restaurantLoc;
	private BigDecimal costOfTwo;
	
	public BigDecimal getCostOfTwo() {
		return costOfTwo;
	}
	public void setCostOfTwo(BigDecimal costOfTwo) {
		this.costOfTwo = costOfTwo;
	}
	public String getRestaurantLoc() {
		return restaurantLoc;
	}
	public void setRestaurantLoc(String restaurantLoc) {
		this.restaurantLoc = restaurantLoc;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
}
