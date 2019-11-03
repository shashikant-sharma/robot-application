package com.xebia.robot.impl;

import java.util.Objects;
import java.util.Random;

import com.xebia.robot.Scanner;
import com.xebia.robot.WalkWithLoadRobot;
import com.xebia.robot.config.Constant;
import com.xebia.robot.enums.Light;
import com.xebia.robot.enums.State;
import com.xebia.robot.exception.ObjectOverWeightException;
import com.xebia.robot.exception.ScanException;

public class WalkingRobot implements WalkWithLoadRobot,Scanner {

	private Settings settings;

	public WalkingRobot() {
		this.settings = new Settings();
	}

	@Override
	public void onOff() {
		if (this.settings.getState().is(State.OFF)) {
			this.settings.setState(State.ON);
			if (settings.getBattery().getLevel() <= settings.getBattaryAlertLevel()) {
				Display.message(Constant.BATTERY_LOW_MESSAGE);
				this.settings.setLight(Light.RED);
			}
		} else {
			this.settings.setState(State.OFF);
		}
	}

	@Override
	public void walk() {
		if (settings.getBattery().getLevel() <= settings.getBattaryAlertLevel()) {
			Display.message(Constant.BATTERY_LOW_MESSAGE);
			this.settings.setLight(Light.RED);
		} else if (settings.getLoad() > settings.getWeightThreshold()) {
			Display.message(Constant.OVERWEIGHT_MESSAGE);
			this.settings.setLight(Light.RED);
			throw new ObjectOverWeightException(Constant.OVERWEIGHT_MESSAGE);
		} else {
			settings.setState(State.WALKING);
			Display.message(Constant.WALKING_MESSAGE);
			this.settings.getBattery().updateLevel(this.settings.batteryRequired());
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

	@Override
	public int scan(byte[] bytes) {
		 Random random=new Random();
	        if(Objects.isNull(bytes))
	            throw new ScanException("Scan Failure");
	        int scannedNo=random.nextInt();
	        return Math.abs(scannedNo);
	}

}
