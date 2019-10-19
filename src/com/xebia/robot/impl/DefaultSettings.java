package com.xebia.robot.impl;

import com.xebia.robot.enums.State;

public abstract class DefaultSettings {
	
	protected int perChargeWalkLimit = 5;
	
	protected int battaryAlertLevel  = 15;
	
	protected int weightThreshold  = 10;
	
	protected State state = State.OFF;
	
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


	public int getWeightThreshold() {
		return weightThreshold;
	}
	
	
	
	
	
	
}
