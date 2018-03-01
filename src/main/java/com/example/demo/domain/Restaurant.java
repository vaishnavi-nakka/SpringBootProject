package com.example.demo.domain;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Restaurant {
	
	@Id
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
