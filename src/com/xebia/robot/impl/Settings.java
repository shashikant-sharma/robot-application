package com.xebia.robot.impl;

import com.xebia.robot.enums.Light;
import com.xebia.robot.enums.State;

public class Settings {

	private double walkingDistance;

	private double load;

	private int perChargeWalkLimit = 5;

	private int battaryAlertLevel = 15;

	private int weightThreshold = 10;

	private State state = State.OFF;
	
	private Light light = Light.OFF;
	

	private final Battery battery = new Battery(100);

	public int getPerChargeWalkLimit() {
		return perChargeWalkLimit;
	}

	public int getBattaryAlertLevel() {
		return battaryAlertLevel;
	}

	public Battery getBattery() {
		return battery;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Light getLight() {
		return light;
	}

	public void setLight(Light light) {
		this.light = light;
	}

	public int getWeightThreshold() {
		return weightThreshold;
	}

	public double getWalkingDistance() {
		return walkingDistance;
	}

	public void setWalkingDistance(double walkingDistance) {
		this.walkingDistance = walkingDistance;
	}

	public double getLoad() {
		return load;
	}

	public void setLoad(double load) {
		this.load = load;
	}

	public double batteryRequired() {
	   double batteryConsumed = (100/perChargeWalkLimit)*walkingDistance;
	   batteryConsumed +=load*2;
	   return batteryConsumed;
       
	}

}
