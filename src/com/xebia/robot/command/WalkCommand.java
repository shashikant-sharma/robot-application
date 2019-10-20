package com.xebia.robot.command;

import com.xebia.robot.WalkableRobot;

public class WalkCommand implements Command {
    
    private WalkableRobot robot;
	
	public WalkCommand(WalkableRobot robot) {
		this.robot =robot;
	}
	
	@Override
	public void execute() {
		robot.walk();
	}
}