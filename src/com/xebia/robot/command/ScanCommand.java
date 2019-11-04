package com.xebia.robot.command;

import com.xebia.robot.WalkWithLoadRobot;

public class ScanCommand implements Command {
	
	private WalkWithLoadRobot robot;
	
	public ScanCommand(WalkWithLoadRobot robot) {
		this.robot =robot;
	}

	@Override
	public void execute() {
		robot.scan();
	}

}
