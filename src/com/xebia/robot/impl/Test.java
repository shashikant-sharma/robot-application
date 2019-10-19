package com.xebia.robot.impl;

public class Test {
	
	public static void main(String[] args) {
		RobotControl control = new RobotControl(new WalkingRobot());
		control.off();
		control.on();
		control.walk();
	}

}
