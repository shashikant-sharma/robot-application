package com.xebia.robot.impl;

import com.xebia.robot.command.Command;

public class RobotCommand {
	
	private Command command;
	
	public RobotCommand(Command command) {
        this.command = command;
	}
	
	public void execute() {
		command.execute();
	}
}
