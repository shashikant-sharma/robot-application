package com.xebia.robot.command;

import com.xebia.robot.Robot;

public class OnOffCommand implements Command {
	
	private Robot robot;
	
	public OnOffCommand(Robot robot) {
		this.robot =robot;
	}

	@Override
	public void execute() {
		robot.onOff();
	}

}
