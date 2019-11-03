package com.xebia.robot.impl;

import com.xebia.robot.WalkWithLoadRobot;
import com.xebia.robot.command.Command;
import com.xebia.robot.command.OnOffCommand;
import com.xebia.robot.command.WalkCommand;

public class RobotControl {
	
	private WalkWithLoadRobot robot;
	
	public RobotControl(WalkWithLoadRobot robot) {
		this.robot = robot;
	}

	public void onOff() {
		Command command = new OnOffCommand(robot);
		RobotCommand context = new RobotCommand(command);
		context.execute();
	}

	public void walk() {
		Command command = new WalkCommand(robot);
		RobotCommand context = new RobotCommand(command);
		context.execute();
	}

}
