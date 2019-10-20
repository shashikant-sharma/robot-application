package com.xebia.robot.impl;

import com.xebia.robot.WeightCarrierRobot;
import com.xebia.robot.config.Constant;
import com.xebia.robot.enums.State;

public class WalkingRobot implements WeightCarrierRobot {

	private Settings settings;

	public WalkingRobot() {
		this.settings = new Settings();
	}

	@Override
	public void on() {
		if (settings.getBattery().getLevel() == 0) {
			Display.message(Constant.BATTERY_DISCHARGED_MESSAGE);
			off();
		} else if (settings.getState().is(State.ON) || settings.getState().is(State.WALKING)) {
			Display.message(Constant.ALREADY_POWER_ON_MESSAGE);
		} else {
			settings.setState(State.ON);
			Display.message(Constant.POWER_ON_MESSAGE);
		}
	}

	@Override
	public void off() {
		if (settings.getState().is(State.OFF)) {
			Display.message(Constant.ALREADY_POWER_OFF_MESSAGE);
		}
		settings.setState(State.OFF);
		Display.message(Constant.POWER_OFF_MESSAGE);
	}

	@Override
	public void walk() {
		if (settings.getState().is(State.OFF)) {
			Display.message(Constant.POWER_OFF_MESSAGE);
		} else if (settings.getBattery().getLevel() <= 0) {
			Display.message(Constant.BATTERY_DISCHARGED_MESSAGE);
			off();
		} else if (settings.getBattery().getLevel() <= settings.getBattaryAlertLevel()) {
			Display.message(Constant.BATTERY_LOW_MESSAGE);
		} else if (settings.getLoad() > settings.getWeightThreshold()) {
			Display.message(Constant.OVERWEIGHT_MESSAGE);
			settings.setState(State.OFF);
		} else {
			settings.setState(State.WALKING);
			Display.message(Constant.WALKING_MESSAGE);
			settings.updateBatteryLevel();
			Display.message(String.format(Constant.BATTERY_LEVEL_MESSAGE, settings.getBattery().getLevel(), "%"));
		}

	}

	@Override
	public Settings getSettings() {
		return settings;
	}

	@Override
	public void load(int load) {
		settings.setLoad(load);
	}

	@Override
	public void setDistance(double distance) {
		settings.setWalkingDistance(distance);
	}

}
