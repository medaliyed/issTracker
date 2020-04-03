package com.example.issTrackerApp;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Iss {
	@Id
	private int timestamp;
	private String message;
	private double latitude;
	private double longitude;
	public Iss() {
		super();
	}
	public Iss(int timestamp, String message, double latitude, double longitude) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	
}
