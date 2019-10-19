package com.xebia.robot.command;

import com.xebia.robot.Walkable;

public class WalkCommand implements Command {
    
    private Walkable robot;
	
	public WalkCommand(Walkable robot) {
		this.robot =robot;
	}
	
	@Override
	public void execute() {
		robot.walk();
	}
}