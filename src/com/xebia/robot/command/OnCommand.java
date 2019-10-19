package com.xebia.robot.command;

import com.xebia.robot.Robot;

public class OnCommand implements Command {
	
	private Robot robot;
	
	public OnCommand(Robot robot) {
		this.robot =robot;
	}

	@Override
	public void execute() {
		robot.on();
	}

}
