package com.xebia.robot.command;

import com.xebia.robot.Robot;

public class OffCommand implements Command {
    
	
    private Robot robot;
	
	public OffCommand(Robot robot) {
		this.robot =robot;
	}
	
	@Override
	public void execute() {
		robot.off();
	}

}
