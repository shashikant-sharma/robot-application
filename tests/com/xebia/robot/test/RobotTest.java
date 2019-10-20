package com.xebia.robot.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.xebia.robot.WeightCarrierRobot;
import com.xebia.robot.impl.RobotControl;
import com.xebia.robot.impl.WalkingRobot;

class RobotTest {

	@Test
	void distance_3_5_weight_0() {
		WeightCarrierRobot robot = new WalkingRobot();
		robot.setDistance(3.5);
		RobotControl control = new RobotControl(robot);
		control.on();
		control.walk();
		assertEquals(30,robot.getSettings().getBattery().getLevel(),"Battery level should be 30 %");
	}
    
	@Test
	void distance_2_weight_3() {
		WeightCarrierRobot robot = new WalkingRobot();
		robot.setDistance(2);
		robot.load(3);
		RobotControl control = new RobotControl(robot);
		control.on();
		control.walk();
		assertEquals(54,robot.getSettings().getBattery().getLevel(),"Battery level should be 54 %");
	}
	
	@Test
	void distance_0_weight_12() {
		WeightCarrierRobot robot = new WalkingRobot();
		robot.setDistance(0);
		robot.load(12);
		RobotControl control = new RobotControl(robot);
		control.on();
		control.walk();
	}
}
