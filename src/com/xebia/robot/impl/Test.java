package com.xebia.robot.impl;

import com.xebia.robot.WeightCarrierRobot;

public class Test {
	
	public static void main(String[] args) {
		WeightCarrierRobot robot = new WalkingRobot();
		robot.setDistance(2);
		robot.load(3);
		RobotControl control = new RobotControl(robot);
		control.on();
		control.walk();
	
	}

}
