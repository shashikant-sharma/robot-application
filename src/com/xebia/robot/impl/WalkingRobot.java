package com.xebia.robot.impl;

import com.xebia.robot.Walkable;
import com.xebia.robot.enums.State;
import com.xebia.robot.exception.BatteryLowException;
import com.xebia.robot.exception.RobotStateException;

public class WalkingRobot implements Walkable{
	
	private DefaultSettings settings;
	
	public WalkingRobot() {
		this.settings = new Settings();
	}

	@Override
	public void walk() {
		if(settings.getState().is(State.OFF)) {
			throw new RobotStateException("Robot is power off, please press on button.");
		}else if(settings.getBattery().getLevel()<=settings.getBattaryAlertLevel()) {
			throw new BatteryLowException("Battery level low..");
		}
		settings.setState(State.WALKING);
		System.out.println("Robot is walking");
	}

	@Override
	public void on() {
		if(settings.getBattery().getLevel()==0) {
			throw new BatteryLowException("Robot battary is discharged");
		}else if(settings.getState().is(State.ON) || settings.getState().is(State.WALKING)) {
			throw new RobotStateException("Robot is already on");
		}
		settings.setState(State.ON);
		System.out.println("Robot is on");
	}

	@Override
	public void off() {
		if(settings.getState().is(State.OFF)) {
			throw new RobotStateException("Robot is already in power off mode.");
		}
		settings.setState(State.OFF);
		System.out.println("Robot is off");
	}
	
	@Override
	public DefaultSettings getSettings() {
		return settings;
	}

}
