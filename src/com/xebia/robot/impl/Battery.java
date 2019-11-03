package com.xebia.robot.impl;

public class Battery {
	
	private double level;
	
	public Battery(double level) {
		this.level = level;
	}

	public double getLevel() {
		return level;
	}

	public void setLevel(double level) {
		this.level = level;
	}
	public void updateLevel(double level) {
		this.level -= level;
	}
	
	

}
