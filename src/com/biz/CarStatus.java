package com.biz;

public class CarStatus {
	int id;
	String direction;
	double speed;
	String speeding;
	
	public CarStatus() {
		super();
	}
	public CarStatus(int id, String direction, double speed, String speeding) {
		super();
		this.id = id;
		this.direction = direction;
		this.speed = speed;
		this.speeding = speeding;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public String getSpeeding() {
		return speeding;
	}
	public void setSpeeding(String speeding) {
		this.speeding = speeding;
	}
	@Override
	public String toString() {
		return "CarStatus [id=" + id + ", direction=" + direction + ", speed=" + speed + ", speeding=" + speeding + "]";
	}
	
	
}
