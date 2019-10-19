package com.xebia.robot.impl;

import com.xebia.robot.Walkable;
import com.xebia.robot.command.Command;
import com.xebia.robot.command.OffCommand;
import com.xebia.robot.command.OnCommand;
import com.xebia.robot.command.WalkCommand;

public class RobotControl {
	
	private Walkable robot;
	
	public RobotControl(Walkable robot) {
		this.robot = robot;
	}

	public void on() {
		Command command = new OnCommand(robot);
		RobotCommand context = new RobotCommand(command);
		context.execute();
	}

	public void off() {
		
		Command command = new OffCommand(robot);
		RobotCommand context = new RobotCommand(command);
		context.execute();
	}

	public void walk() {
		Command command = new WalkCommand(robot);
		RobotCommand context = new RobotCommand(command);
		context.execute();
	}

}
