package com.xebia.robot;

import com.xebia.robot.impl.Settings;

public interface Robot  {
   
	public void on();
	
	public void off();
	
	public Settings getSettings();
}
