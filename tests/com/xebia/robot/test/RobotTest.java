package com.xebia.robot.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.xebia.robot.WalkWithLoadRobot;
import com.xebia.robot.enums.State;
import com.xebia.robot.exception.ObjectOverWeightException;
import com.xebia.robot.exception.ScanException;
import com.xebia.robot.impl.RobotControl;
import com.xebia.robot.impl.WalkingRobot;

class RobotTest {

	@Test
	void test_energyConsumed_while_walking_3_5_kms() {
		WalkWithLoadRobot robot = new WalkingRobot();
		robot.setDistance(3.5);
		RobotControl control = new RobotControl(robot);
		control.onOff();
		control.walk();
		assertEquals(30,robot.getSettings().getBattery().getLevel(),"Battery level should be 30 %");
	}
    
	@Test
	void robot_walks_for_2_km_carrying_3_kg_weight() {
		WalkWithLoadRobot robot = new WalkingRobot();
		robot.setDistance(2);
		robot.load(3);
		RobotControl control = new RobotControl(robot);
		control.onOff();
		control.walk();
		assertEquals(54,robot.getSettings().getBattery().getLevel(),"Battery level should be 54 %");
	}
	
	@Test
	void robot_carries_12_km_weight() {
		WalkWithLoadRobot robot = new WalkingRobot();
		robot.setDistance(0);
		robot.load(12);
		RobotControl control = new RobotControl(robot);
		control.onOff();
		Assertions.assertThrows(ObjectOverWeightException.class, () -> control.walk());
	}
	
	@Test
	void on_off() {
		WalkWithLoadRobot robot = new WalkingRobot();
		RobotControl control = new RobotControl(robot);
		control.onOff();
		assertEquals(robot.getSettings().getState(),State.ON);
		control.onOff();
		assertEquals(robot.getSettings().getState(),State.OFF);
	}
	
	 public void scanning_an_image_scan_failure(){
		 WalkWithLoadRobot robot = new WalkingRobot();
			RobotControl control = new RobotControl(robot);
			control.onOff();
			Assertions.assertThrows(ScanException.class, () -> control.scan());
	    }
}
